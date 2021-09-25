package com.example.android.popularlibraries.presenter

interface MainView {

    fun showError(message: String)
    fun showJPGImage(uriString: String)
    fun showToast(message: String)
    fun showDialog()
}