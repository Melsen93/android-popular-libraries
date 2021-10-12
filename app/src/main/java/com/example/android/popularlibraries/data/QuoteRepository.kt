package com.example.android.popularlibraries.data

import com.example.android.popularlibraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single

interface QuoteRepository {

    fun getQuote(): Single<Quote>
}