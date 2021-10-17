package com.example.android.popularlibraries.basic.quoteshistory

import dagger.assisted.AssistedFactory

@AssistedFactory
interface QuotesHistoryPresenterFactory {
    fun create(): QuotesHistoryPresenter
}