package com.example.android.popularlibraries.basic.quote

import dagger.assisted.AssistedFactory

@AssistedFactory
interface QuotePresenterFactory {
    fun create(): QuotePresenter
}