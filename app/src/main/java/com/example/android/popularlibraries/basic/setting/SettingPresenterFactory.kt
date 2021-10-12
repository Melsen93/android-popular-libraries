package com.example.android.popularlibraries.basic.setting

import dagger.assisted.AssistedFactory

@AssistedFactory
interface SettingPresenterFactory {
    fun create(): SettingPresenter
}