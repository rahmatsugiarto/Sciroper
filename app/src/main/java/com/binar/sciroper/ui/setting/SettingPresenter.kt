package com.binar.sciroper.ui.setting

interface SettingPresenter {
    fun checkDarkMode(): Boolean?
    fun setDarkMode(isDarkMode: Boolean)
}