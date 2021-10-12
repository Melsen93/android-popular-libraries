package com.example.android.popularlibraries.basic.main

import dagger.assisted.AssistedFactory

@AssistedFactory
interface MainPresenterFactory {
    fun create(): MainPresenter
}