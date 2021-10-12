package com.example.android.popularlibraries.basic.quoteshistory

import com.example.android.popularlibraries.basic.BasePresenter
import com.example.android.popularlibraries.data.db.repositories.QuoteDB
import com.example.android.popularlibraries.data.entities.Quote
import com.example.android.popularlibraries.helpers.schedules.AppSchedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.kotlin.plusAssign

class QuotesHistoryPresenter @AssistedInject constructor(
    router: Router,
    private val quoteDB: QuoteDB,
    private val schedulers: AppSchedulers,
) : BasePresenter<QuotesHistoryView>(router), QuoteHistoryListPresenter {

    private val quotes = mutableListOf<Quote>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    override fun bindView(view: QuoteItemView) {
        view.setData(quotes[view.currentPosition])
    }

    override fun getCount() = quotes.size

    private fun loadData() {
        disposables +=
            quoteDB
                .getQuotes()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    { quotesDB ->
                        quotes.addAll(quotesDB)
                        viewState.updateList()
                    },
                    { exception -> viewState.showException(exception) }
                )
    }
}