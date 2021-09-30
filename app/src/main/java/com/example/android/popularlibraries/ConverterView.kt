package com.example.android.popularlibraries

import android.net.Uri
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ConverterView : ScreenView {

    @AddToEndSingle
    fun showContent(uri: Uri?)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showOnBoarding()

}