package com.example.picpaytest.feature.payment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.picpaytest.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PaymentActivity : AppCompatActivity(), PaymentContract.View {

    override val presenter by inject<PaymentPresenter> { parametersOf(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
    }
}
