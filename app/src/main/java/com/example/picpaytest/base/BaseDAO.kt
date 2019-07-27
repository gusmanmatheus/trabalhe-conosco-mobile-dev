package com.example.picpaytest.base

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.picpaytest.R
import com.example.picpaytest.data.local.CREDIT_CARD
import com.example.picpaytest.data.model.CreditCard

abstract class BaseDAO (context: Context):SQLiteOpenHelper(
    context,
    context.resources.getString(R.string.name_db),
    null,
    context.resources.getInteger(R.integer.version_db)){

    abstract val query: String

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(query) //temos certeza que nao vai ser nulo, 'e obrigatori implementar a query
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL( "DROP TABLE IF EXISTS"+CREDIT_CARD.NAME_HOLDER)
        onCreate(db)
    }
}



