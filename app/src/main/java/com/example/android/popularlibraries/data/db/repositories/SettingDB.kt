package com.example.android.popularlibraries.data.db.repositories

import com.example.android.popularlibraries.data.entities.Setting
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SettingDB {

    fun save(setting: Setting): Completable

    fun getSetting(name: String): Single<Setting>

    fun getSettings(): Single<List<Setting>>
}