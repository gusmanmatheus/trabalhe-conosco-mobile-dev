package com.example.picpaytest.feature.payment

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView
import com.example.picpaytest.data.model.CreditCard
import com.example.picpaytest.data.model.Transaction
import com.example.picpaytest.data.model.User

interface PaymentContract {
    interface View: BaseView<Presenter> {
        fun setDataScreenUser(photo:String,nickname:String)
        fun setDataScreenCard(cardName:String)
        fun bottomSheed(transaction: Transaction)
        fun transactionRefused()
        fun loadViewOn()
        fun loadViewOff()
        fun showError(failure: String)

    }
    interface Presenter:BasePresenter<View>{
        fun sendPayment(value: String)
        fun setDataUser(user: User)
        fun setDataCard(card: CreditCard)
        fun getShared()
        fun deleteShared()
        fun convertToDate(time: String):String
    }
}