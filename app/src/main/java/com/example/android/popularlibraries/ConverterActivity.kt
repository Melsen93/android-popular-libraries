package com.example.android.popularlibraries

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import com.example.android.popularlibraries.App.Navigation.navigatorHolder
import com.example.android.popularlibraries.App.Navigation.router

class ConverterActivity: MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(ConverterScreen)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}