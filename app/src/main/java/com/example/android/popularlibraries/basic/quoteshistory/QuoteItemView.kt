package com.example.android.popularlibraries.basic.quoteshistory

import com.example.android.popularlibraries.data.entities.Quote

interface QuoteItemView {
    var currentPosition: Int

    fun setData(quote: Quote)
}