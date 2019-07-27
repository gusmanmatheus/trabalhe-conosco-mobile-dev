package com.example.picpaytest.base.modules

import com.example.picpaytest.data.remote.ServiceRequest
import com.example.picpaytest.feature.contacts.ContactsContract
import com.example.picpaytest.feature.contacts.ContactsPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

val moduleContact = module {
    factory { ServiceRequest() }
    factory {(view: ContactsContract.View) ->
        ContactsPresenter(
            view = view,
            serviceRequest = get())
} bind ContactsPresenter::class}