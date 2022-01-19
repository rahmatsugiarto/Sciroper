package com.binar.sciroper.ui.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.widget.SwitchCompat
import com.binar.sciroper.R
import com.binar.sciroper.data.local.AppSharedPreference
import com.binar.sciroper.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity(), SettingView {
    private val presenter: SettingPresenter = SettingPresenterImpl(this)
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when(presenter.checkDarkMode()) {
            false -> binding.switchDarkMode.isChecked = false
            true -> binding.switchDarkMode.isChecked = true
            else -> binding.switchDarkMode.isChecked = false
        }

        binding.switchDarkMode.setOnClickListener {
            if ((it as SwitchCompat).isChecked) {
                presenter.setDarkMode(true)
            } else {
                presenter.setDarkMode(false)
            }
        }

        binding.btnFromSettingToProfile.setOnClickListener {
            // GOTO PROFILE ACTIVITY
        }

        binding.backBtnFromSetting.setOnClickListener { finish() }

    }

    override fun setTheme(isDarkMode: Boolean?) {
        if (isDarkMode != null) {
            if (isDarkMode){
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        }
    }
}