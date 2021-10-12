package com.example.android.popularlibraries.di.modules

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.android.popularlibraries.data.db.StorageDB
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideStorageDB(context: Context): StorageDB =
        Room.databaseBuilder(context.applicationContext, StorageDB::class.java, StorageDB.DB_NAME)
            .setQueryCallback({ sql, param ->
                Log.d("DBSql", "SQL: $sql, param: $param")
            }, Executors.newSingleThreadExecutor())
            .fallbackToDestructiveMigration()
            .build()
}