package com.example.android.popularlibraries.data.db.repositories

import com.example.android.popularlibraries.data.db.StorageDB
import com.example.android.popularlibraries.data.entities.Setting
import javax.inject.Inject

class SettingDBImpl @Inject constructor(private val storageDB: StorageDB) : SettingDB {
    override fun save(setting: Setting) = storageDB.settingDao().insert(setting)

    override fun getSetting(name: String) = storageDB.settingDao().getSetting(name)

    override fun getSettings() = storageDB.settingDao().getSettings()
}