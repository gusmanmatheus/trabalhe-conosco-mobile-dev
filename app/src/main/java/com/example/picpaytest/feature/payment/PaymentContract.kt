package com.example.picpaytest.feature.payment

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView

interface PaymentContract {
    interface View: BaseView<Presenter> {

    }
    interface Presenter:BasePresenter<View>{

    }
}