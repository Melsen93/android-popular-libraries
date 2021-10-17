package com.example.android.popularlibraries.data.db.repositories

import com.example.android.popularlibraries.data.db.StorageDB
import com.example.android.popularlibraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuoteDBImpl @Inject constructor(private val storageDB: StorageDB) : QuoteDB {

    override fun insert(quote: Quote) = storageDB.quoteDao().insert(quote)

    override fun getQuotes(): Single<List<Quote>> = storageDB.quoteDao().getQuotes()

    override fun delete(quote: Quote) = storageDB.quoteDao().delete(quote)
}