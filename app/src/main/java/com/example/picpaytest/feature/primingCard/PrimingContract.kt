package com.example.picpaytest.feature.primingCard

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView
import com.example.picpaytest.data.model.User

interface PrimingContract {
    interface View:BaseView<Presenter>{
        fun nextActivity(user: User)
        fun recoveryData():User
    }
    interface Presenter:BasePresenter<View> {
        fun route()

    }
}