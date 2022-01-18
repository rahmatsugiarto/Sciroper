package com.binar.sciroper.ui.setting

import com.binar.sciroper.data.local.AppSharedPreference

class SettingPresenterImpl(private val view: SettingView): SettingPresenter {
    override fun setDarkMode(isDarkMode: Boolean) {
        AppSharedPreference.isDarkMode = isDarkMode
        view.setTheme(isDarkMode)
    }

    override fun checkDarkMode() {
        view.setTheme(AppSharedPreference.isDarkMode)
    }
}