package com.example.picpaytest.base.modules

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

abstract class BaseSharedPreferences<T>(val context: Context) {
    abstract val PREFERENCE_NAME:String
    abstract val PREFERENCE_VALUE:String
    abstract val preferences:SharedPreferences

    fun getValue(key:ValuesKeys,obj:Class<T>):T{
        val json = preferences.getString(key.toString(),"")
        return Gson().fromJson(json,obj)
    }
    fun setValue(value:T){
        val json = Gson().toJson(value)
        val editor = preferences.edit()
        editor.putString(PREFERENCE_VALUE,json)
        editor.apply()
    }
    fun delete(){
        val editor = preferences.edit()
        editor.clear()
        editor.commit()
    }
     enum class ValuesKeys{
        VALUE_CARD,
        NAME_CARD
    }
}