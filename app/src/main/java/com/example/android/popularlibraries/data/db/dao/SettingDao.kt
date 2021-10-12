package com.example.android.popularlibraries.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.popularlibraries.data.db.StorageDB
import com.example.android.popularlibraries.data.entities.Setting
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface SettingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(setting: Setting): Completable

    @Query("select * from ${StorageDB.TABLE_SETTING} where ${StorageDB.SETTING_NAME} = :name")
    fun getSetting(name: String): Single<Setting>

    @Query("select * from ${StorageDB.TABLE_SETTING}")
    fun getSettings(): Single<List<Setting>>
}