package com.example.android.popularlibraries

import com.example.android.popularlibraries.di.DaggerAppComponent
import com.example.android.popularlibraries.helpers.schedules.AppSchedulersImpl
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent
            .builder()
            .apply {
                withContext(applicationContext)

                val cicerone = Cicerone.create()
                withNavigationHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withAppScheduler(AppSchedulersImpl())
            }
            .build()
}
