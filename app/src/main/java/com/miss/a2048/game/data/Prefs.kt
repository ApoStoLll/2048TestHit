package com.miss.a2048.game.data

import android.content.Context
import android.content.SharedPreferences

class Prefs(val context: Context) {

    var pref : SharedPreferences? = null

    fun getSp(name : String){
        pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    fun getStr(name : String) : String?{
        return pref?.getString(name, null)
    }

    fun putStr(name : String, value : String){
        pref?.edit()?.putString(name, value)?.apply()
    }

    fun getInt(name : String) : Int?{
        return pref?.getInt(name, -1)
    }

    fun putInt(name : String, value : Int){
        pref?.edit()?.putInt(name, value)?.apply()
    }
}