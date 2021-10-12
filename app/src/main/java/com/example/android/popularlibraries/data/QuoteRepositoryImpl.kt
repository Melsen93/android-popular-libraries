package com.example.android.popularlibraries.data

import com.example.android.popularlibraries.data.api.ForismaticApi
import com.example.android.popularlibraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val forismaticApi: ForismaticApi,
) : QuoteRepository {

    override fun getQuote(): Single<Quote> = forismaticApi.getQuote()
}