package com.example.picpaytest.feature.registerCard

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView
import com.example.picpaytest.data.model.CreditCard

interface RegisterContract {
    interface View:BaseView<Presenter>{
        fun dialogError(message:String)
        fun nextActivity(creditCard: CreditCard)

    }
    interface Presenter:BasePresenter<View> {
        fun storeCard(card: CreditCard)
    }
}