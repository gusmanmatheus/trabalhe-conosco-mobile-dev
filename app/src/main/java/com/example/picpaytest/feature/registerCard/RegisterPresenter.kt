package com.example.picpaytest.feature.registerCard

import com.example.picpaytest.data.local.CreditCardDao
import com.example.picpaytest.data.model.CreditCard

class RegisterPresenter(
    override var view: RegisterContract.View,
    val db: CreditCardDao
):RegisterContract.Presenter {

    override fun storeCard(card:CreditCard) {
        if (db.insert(card)) {
            view.nextActivity(card)
        } else {
            view.dialogError()
        }
    }
}