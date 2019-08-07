package com.example.picpaytest.feature.contacts

import com.example.picpaytest.base.BasePresenter
import com.example.picpaytest.base.BaseView
import com.example.picpaytest.data.model.User

interface ContactsContract {
    interface View : BaseView<Presenter> {
        fun setListUsers(users: ArrayList<User>)
        fun showError(error: String)
        fun recoveryUsers(users: ArrayList<User>)
    }
    interface Presenter: BasePresenter<View> {
        fun getUsers()
        fun filterList(filter: String)
    }
}