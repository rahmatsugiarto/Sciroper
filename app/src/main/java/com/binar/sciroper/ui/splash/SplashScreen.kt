package com.binar.sciroper.ui.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import com.binar.sciroper.R
import com.binar.sciroper.data.local.AppSharedPreference
import com.binar.sciroper.data.local.AppSharedPreference.isLogin
import com.binar.sciroper.ui.landing.LandingPageActivity
import com.binar.sciroper.ui.menu.MenuActivity
import com.binar.sciroper.util.goto

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val delaySplashScreen = 2000L
        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin == true) {
                goto(MenuActivity::class.java)
            } else {
                goto(LandingPageActivity::class.java)
            }
            finish()
        }, delaySplashScreen)

        if (AppSharedPreference.isDarkMode!!) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}