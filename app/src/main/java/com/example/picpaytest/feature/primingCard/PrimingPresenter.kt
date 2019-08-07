package com.example.picpaytest.feature.primingCard

class PrimingPresenter(
    override var view:PrimingContract.View
):PrimingContract.Presenter {
    override fun route() {
        val user = view.recoveryData()
        view.nextActivity(user)
    }

}