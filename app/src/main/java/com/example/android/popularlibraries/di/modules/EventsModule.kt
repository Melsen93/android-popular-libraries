package com.example.android.popularlibraries.di.modules

import com.example.android.popularlibraries.data.events.BaseHandler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventsModule {

    @Singleton
    @Provides
    fun providerBaseHandler() = BaseHandler()
}