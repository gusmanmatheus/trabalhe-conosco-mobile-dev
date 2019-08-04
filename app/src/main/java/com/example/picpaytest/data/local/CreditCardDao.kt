package com.example.picpaytest.data.local

import android.content.ContentValues
import android.content.Context
import com.example.picpaytest.base.BaseDAO
import com.example.picpaytest.data.model.CreditCard
import java.lang.Exception

class CreditCardDao(val context: Context): BaseDAO(context){
    override val query: String
        get() = CREDIT_CARD.query

    fun insert(card: CreditCard):Boolean{
        val db = writableDatabase
        var result =  true
        try {
            db.insert(CREDIT_CARD.TABLE_NAME,null,objectToContentValues(card))
        }catch (e: Exception){
            result = false
        }finally {
            db.close()
        }
        return result
    }

    fun getCards(): ArrayList<CreditCard> {
        val db = writableDatabase

        var listCredCards = ArrayList<CreditCard>()

        val columns:Array<String> =
            arrayOf(
                CREDIT_CARD.ID_CARD,
                CREDIT_CARD.CARD_NUMBER,
                CREDIT_CARD.NAME_HOLDER,
                CREDIT_CARD.EXPIRY_DATE,
                CREDIT_CARD.CVV
            )
        val cursor = db.query(CREDIT_CARD.TABLE_NAME,columns,null, null,null,null, CREDIT_CARD.NAME_HOLDER)
        cursor?.let {
            cursor.moveToFirst()
            do{
                listCredCards.add(
                    CreditCard(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ))
            }while (cursor.moveToNext())
        }
        db.close()
        return listCredCards
    }

    fun objectToContentValues(card: CreditCard):ContentValues {
        val values = ContentValues()
        values.put(CREDIT_CARD.CARD_NUMBER,card.numberCard)
        values.put(CREDIT_CARD.NAME_HOLDER,card.holderName)
        values.put(CREDIT_CARD.EXPIRY_DATE,card.expirationDate)
        values.put(CREDIT_CARD.CVV,card.cvvCard)
        return values
    }
}
