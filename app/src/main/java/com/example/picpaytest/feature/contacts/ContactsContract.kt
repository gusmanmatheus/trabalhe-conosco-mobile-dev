package com.example.picpaytest.feature.contacts

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView

interface ContactsContract {
interface View :BaseView<Presenter>{
}
interface Presenter: BasePresenter<View>{
    fun test()
    fun testUser()
    fun testSendRequest()
}
}