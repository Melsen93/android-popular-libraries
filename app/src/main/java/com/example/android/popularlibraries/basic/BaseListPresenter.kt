package com.example.android.popularlibraries.basic

interface BaseListPresenter<T> {

    fun bindView(view: T)

    fun getCount(): Int
}