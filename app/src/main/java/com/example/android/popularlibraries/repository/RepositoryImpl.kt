package com.example.android.popularlibraries.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import com.example.android.popularlibraries.App
import com.example.android.popularlibraries.R
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class RepositoryImpl : Repository {

    companion object {
        const val JPG_FILE = "leopard.jpg"
        const val PNG_FILE = "leopard.png"
    }

    override fun getDir(): Observable<File> {
        var sdCard: File? = null
        val sdState = Environment.getExternalStorageState()
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            try {
                sdCard = App.instance.applicationContext
                    .getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        } else if (sdState.equals(Environment.MEDIA_SHARED)) {
            try {
                sdCard = App.instance.filesDir
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
        val sdCardCat = File(sdCard, "/MyImages")
        sdCardCat.mkdir()
        return Observable.just(sdCardCat)
    }

    override fun saveJPGFile(fileRepo: File?): Completable = Completable.create { emitter ->
        saveJPG(fileRepo).let {
            if (it) {
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException("Ошибка при сохранении в JPG файл "))
                return@create
            }
        }
    }

    private fun saveJPG(fileRepo: File?): Boolean {
        val file = File(fileRepo, JPG_FILE)
        if (file.exists()) file.delete()
        val bitmap = BitmapFactory.decodeResource(App.instance.resources, R.drawable.leopard)
        var fOut: OutputStream? = null
        return try {
            fOut = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
            fOut.flush()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            fOut?.close()
        }
    }

    override fun convertJPGtoPNG(file: File): Completable = Completable.create { emitter ->
        convertToPNG(file).let {
            if (it) {
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException("Ошибка конвертации JPG в PNG"))
            }
        }
    }

    private fun convertToPNG(file: File): Boolean {
        var fOut: OutputStream? = null
        val oldFile = File(file, JPG_FILE)
        val bitmap = BitmapFactory.decodeFile(oldFile.absolutePath)
        val newFile = File(file, PNG_FILE)
        return try {
            fOut = FileOutputStream(newFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, fOut)
            fOut.flush()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            fOut?.close()
        }
    }

}