package com.example.android.popularlibraries.basic.setting

import com.example.android.popularlibraries.basic.ExceptionView
import com.example.android.popularlibraries.data.entities.Setting
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface SettingView : MvpView, ExceptionView {

    fun init()

    fun startLoadData()

    fun endLoadData()

    fun showSettings(settings: List<Setting>)
}