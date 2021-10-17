package com.example.android.popularlibraries.basic.quoteshistory

import com.example.android.popularlibraries.basic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface QuotesHistoryView : MvpView, ExceptionView {

    fun init()

    fun updateList()
}