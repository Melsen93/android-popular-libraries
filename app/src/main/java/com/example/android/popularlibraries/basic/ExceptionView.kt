package com.example.android.popularlibraries.basic

import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface ExceptionView {
    fun showException(throwable: Throwable)
}