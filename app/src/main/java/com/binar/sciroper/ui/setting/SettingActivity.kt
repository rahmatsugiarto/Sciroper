package com.binar.sciroper.ui.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.sciroper.R

class SettingActivity : AppCompatActivity(), SettingView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
    }

    override fun setTheme(isDarkMode: Boolean) {
        if (isDarkMode){
        } else {

        }
    }
}