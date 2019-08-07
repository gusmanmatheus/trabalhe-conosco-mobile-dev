package com.example.picpaytest.feature.payment

import android.text.format.DateFormat
import com.example.picpaytest.base.modules.BaseSharedPreferences
import com.example.picpaytest.data.model.CreditCard
import com.example.picpaytest.data.model.Payment
import com.example.picpaytest.data.model.PaymentCallback
import com.example.picpaytest.data.model.User
import com.example.picpaytest.data.remote.ServiceRequest
import java.util.*

class PaymentPresenter(
    override var view: PaymentContract.View,
    val service:ServiceRequest,
    val shared:CardSP
):PaymentContract.Presenter{
    lateinit var user: User
    lateinit var card: CreditCard


    override fun setDataUser(user: User) {
    this.user = user
        view.setDataScreenUser(user.img,user.username)
    }

    override fun setDataCard(card: CreditCard) {
        this.card = card
        view.setDataScreenCard(card.holderName)
    }

    override fun getShared() {
        val newCard:CreditCard = shared.getValue(BaseSharedPreferences.ValuesKeys.VALUE_CARD,CreditCard::class.java)
       newCard?.let {
           setDataCard(newCard)
       }
    }

    override fun deleteShared() {
        shared.delete()
    }

    override fun sendPayment(value:String) {
        view.loadViewOn()
        val payment = Payment(card.numberCard,card.cvvCard,value,card.expirationDate,user.id)
        service.setPayment(
            fun(paymentCallback:PaymentCallback){
                if (paymentCallback.transaction.success) {
                    view.loadViewOff()
                    view.bottomSheed(paymentCallback.transaction)
                }else{
                    view.loadViewOff()
                    view.transactionRefused()

                }
        },fun(failure){
        view.loadViewOff()
                view.showError(failure)
        },payment)
    }

    override fun convertToDate(time: String):String {

        val  cal = Calendar.getInstance(Locale.ENGLISH)
        cal.timeInMillis = (time.toLong() * 1000L)
        return DateFormat.format("dd/MM/yyyy", cal).toString() +
                " às "+DateFormat.format("hh:mm",cal).toString()
    }
}