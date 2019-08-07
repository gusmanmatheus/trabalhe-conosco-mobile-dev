package com.example.picpaytest.feature.contacts

import com.example.picpaytest.data.model.User
import com.example.picpaytest.data.remote.ServiceRequest

class ContactsPresenter(
    override var view: ContactsContract.View,
    val serviceRequest: ServiceRequest
) : ContactsContract.Presenter {

    var users = ArrayList<User>()
    override fun getUsers() {
        serviceRequest
            .getUsers(
                fun(users) {
                    this.users = users
                    view.recoveryUsers(users)
                },
                fun(error) {
                    view.showError(error)
                })
    }
    override fun filterList(filter: String) {
        var filteredList = ArrayList<User>()
        this.users.forEach {
            if (it.name.toLowerCase().contains(filter.toLowerCase()) ||
                it.username.toLowerCase().contains(filter.toLowerCase())){
                filteredList.add(it)
            }
        }
        view.setListUsers(filteredList)
    }

}
