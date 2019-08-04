package com.example.picpaytest.feature.primingCard

import com.example.picpaytest.data.model.User

class PrimingPresenter(
    override var view:PrimingContract.View
):PrimingContract.Presenter {
    override fun route() {
        val user = view.recoveryData()
        view.nextActivity(user)
    }

}