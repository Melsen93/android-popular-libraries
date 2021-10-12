package com.example.android.popularlibraries.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.android.popularlibraries.data.db.StorageDB

@Entity(
    tableName = StorageDB.TABLE_SETTING,
    indices = [
        Index(StorageDB.SETTING_NAME)
    ]
)
data class Setting(

    @ColumnInfo(name = StorageDB.SETTING_NAME)
    @PrimaryKey
    var settingName: String,

    @ColumnInfo(name = StorageDB.SETTING_VALUE)
    val value: String,
)