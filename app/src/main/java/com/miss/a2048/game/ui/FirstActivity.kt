package com.miss.a2048.game.ui

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.example.a2048clone.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        supportActionBar?.hide()
        actionBar?.hide()
    }

//    fun openChrome(url : String){
//        Log.e("Launch", url)
//        val builder = CustomTabsIntent.Builder()
//        builder.setToolbarColor(ContextCompat.getColor(this, R.color.black))
//        val customTabsIntent = builder.build()
//        //job.cancel()
//        customTabsIntent.launchUrl(this, Uri.parse(url))
//        finish()
//    }
}