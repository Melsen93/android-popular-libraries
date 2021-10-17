package com.example.android.popularlibraries.di.modules

import com.example.android.popularlibraries.basic.main.MainActivity
import com.example.android.popularlibraries.basic.quote.QuoteFragment
import com.example.android.popularlibraries.basic.quoteshistory.QuotesHistoryFragment
import com.example.android.popularlibraries.basic.setting.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface UIModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindQuoteFragment(): QuoteFragment

    @ContributesAndroidInjector
    fun bindQuotesHistoryFragment(): QuotesHistoryFragment

    @ContributesAndroidInjector
    fun bindSettingFragment(): SettingFragment
}