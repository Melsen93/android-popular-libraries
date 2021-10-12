package com.example.android.popularlibraries.di

import android.content.Context
import com.example.android.popularlibraries.App
import com.example.android.popularlibraries.di.modules.*
import com.example.android.popularlibraries.helpers.schedules.AppSchedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApiModule::class,
    UIModule::class,
    DataModule::class,
    DBModule::class,
    EventsModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigationHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withAppScheduler(appSchedulers: AppSchedulers): Builder

        fun build(): AppComponent
    }
}