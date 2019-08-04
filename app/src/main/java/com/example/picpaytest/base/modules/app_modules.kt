package com.example.picpaytest.base.modules

import com.example.picpaytest.data.local.CreditCardDao
import com.example.picpaytest.data.remote.ServiceRequest
import com.example.picpaytest.feature.contacts.ContactsContract
import com.example.picpaytest.feature.contacts.ContactsPresenter
import com.example.picpaytest.feature.primingCard.PrimingContract
import com.example.picpaytest.feature.primingCard.PrimingPresenter
import com.example.picpaytest.feature.registerCard.RegisterContract
import com.example.picpaytest.feature.registerCard.RegisterPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

val baseModules = module {
    factory {
        CreditCardDao(get())
    }
    factory {
        ServiceRequest()
    }
}

val modulesContact = module {
    factory {(view: ContactsContract.View) ->
        ContactsPresenter(
            view = view,
            serviceRequest = get()
        )
    } bind ContactsPresenter::class
}

val modulesPriming = module {
    factory {
            (view: PrimingContract.View) ->
        PrimingPresenter(
            view = view
        )
    } bind PrimingPresenter::class
}

val modulesRegister = module {
    factory {
            (view: RegisterContract.View) ->
        RegisterPresenter(
            view = view,
            db = get()
        )
    } bind PrimingPresenter::class
}

val modulesPayment = module {
    factory { (view:PrimingContract.View)->
            PrimingPresenter(
                view = view
            )
    }bind PrimingPresenter::class
}
