package com.example.picpaytest.feature.payment

import android.content.Context
import android.content.SharedPreferences
import com.example.picpaytest.R
import com.example.picpaytest.base.modules.BaseSharedPreferences
import com.example.picpaytest.data.model.CreditCard

class CardSP (context: Context):BaseSharedPreferences<CreditCard>(context) {
    override val preferences: SharedPreferences
        get() = context.getSharedPreferences(context.resources.getString(R.string.PREFERENCESCARD),Context.MODE_PRIVATE)
    override val PREFERENCE_NAME: String
        get() = ValuesKeys.NAME_CARD.toString()
    override val PREFERENCE_VALUE: String
        get() = ValuesKeys.VALUE_CARD.toString()
}