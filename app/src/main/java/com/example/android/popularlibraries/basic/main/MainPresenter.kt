package com.example.android.popularlibraries.basic.main

import com.example.android.popularlibraries.basic.BasePresenter
import com.example.android.popularlibraries.basic.quote.QuoteScreen
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import moxy.MvpView

class MainPresenter @AssistedInject constructor(
    router: Router,
) : BasePresenter<MvpView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(QuoteScreen())
    }
}