package com.example.picpaytest.data.local

class CREDIT_CARD {
    companion object{
        val TABLE_NAME = "CREDIT_CARD"
        val ID_CARD = "_id"
        val CARD_NUMBER = "CARD_NUMBER"
        val NAME_HOLDER = "NAME_HOLDER"
        val EXPIRY_DATE = "EXPIRY_DATE"
        val CVV = "CVV"
        val query = "create table ${TABLE_NAME}" +
                " (${ID_CARD} integer primary key autoincrement," +
                " ${CARD_NUMBER} text not null," +
                " ${NAME_HOLDER} text not null," +
                " ${EXPIRY_DATE} text not null, " +
                " ${CVV} int not null  );"


    }
}