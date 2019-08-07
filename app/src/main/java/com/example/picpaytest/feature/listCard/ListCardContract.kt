package com.example.picpaytest.feature.listCard

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView
import com.example.picpaytest.data.model.CreditCard

interface ListCardContract {
    interface View: BaseView<Presenter> {
        fun setupList()
        fun error()
    }
    interface Presenter:BasePresenter<View>{
        fun setList()
        fun addShared(card:CreditCard)

    }
}