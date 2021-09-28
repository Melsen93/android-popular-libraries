package com.example.android.popularlibraries.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState()
interface UserView : MvpView {
    fun setLogin(text: String)
}