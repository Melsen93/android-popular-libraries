package com.example.android.popularlibraries.presenter

import com.example.android.popularlibraries.R
import com.example.android.popularlibraries.model.CountersModel
import com.example.android.popularlibraries.view.MainView

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(id: Int) {
        when (id) {
            R.id.buttonCounter1 -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.buttonCounter2 -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.buttonCounter3 -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }

}