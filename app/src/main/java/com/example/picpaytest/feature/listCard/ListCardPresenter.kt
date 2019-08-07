package com.example.picpaytest.feature.listCard

import com.example.picpaytest.data.local.CreditCardDao
import com.example.picpaytest.data.model.CreditCard
import com.example.picpaytest.feature.payment.CardSP

class ListCardPresenter(
    override var view: ListCardContract.View,
    val db: CreditCardDao,
    val shared: CardSP

):ListCardContract.Presenter {
    lateinit var listCard :ArrayList<CreditCard>

    override fun setList() {
        this.listCard = db.getCards()
        if (listCard.size > 0){
            view.setupList()
        }
        else{
             view.error()
        }
    }

    override fun addShared(card:CreditCard) {
        shared.setValue(card)
    }
}