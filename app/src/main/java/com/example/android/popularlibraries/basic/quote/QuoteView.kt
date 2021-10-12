package com.example.android.popularlibraries.basic.quote

import com.example.android.popularlibraries.basic.ExceptionView
import com.example.android.popularlibraries.data.entities.Quote
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface QuoteView : MvpView, ExceptionView {

    fun init()

    fun startUpdateQuote()

    fun endUpdateQuote()

    fun showQuote(quote: Quote)

    fun showReverseTimer(value: Int)
}