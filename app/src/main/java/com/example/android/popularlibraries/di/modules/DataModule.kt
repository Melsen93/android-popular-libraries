package com.example.android.popularlibraries.di.modules

import com.example.android.popularlibraries.data.QuoteRepository
import com.example.android.popularlibraries.data.QuoteRepositoryImpl
import com.example.android.popularlibraries.data.db.repositories.QuoteDB
import com.example.android.popularlibraries.data.db.repositories.QuoteDBImpl
import com.example.android.popularlibraries.data.db.repositories.SettingDB
import com.example.android.popularlibraries.data.db.repositories.SettingDBImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {
    @Singleton
    @Binds
    fun bindQuoteRepository(repository: QuoteRepositoryImpl): QuoteRepository

    @Singleton
    @Binds
    fun bindQuoteDB(quoteDB: QuoteDBImpl): QuoteDB

    @Singleton
    @Binds
    fun bindSettingDB(settingDB: SettingDBImpl): SettingDB
}