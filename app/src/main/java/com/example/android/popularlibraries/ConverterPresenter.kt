package com.example.android.popularlibraries

import android.net.Uri
import com.example.android.popularlibraries.converter.Converter
import com.example.android.popularlibraries.scheduler.Schedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

class ConverterPresenter(
    private val converter: Converter,
    private val schedulers: Schedulers,
) : MvpPresenter<ConverterView>() {

    private val disposables = CompositeDisposable()

    fun convert(uri: Uri) {
        viewState.showContent(uri)
        viewState.showOnBoarding()

        disposables.add(
            converter
                .convert(uri)
                .delay(3, TimeUnit.SECONDS)
                .cache()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showContent,
                    viewState::showError
                )
        )
    }

    fun cancel() {
        viewState.showContent(null)
        disposables.clear()
    }

    override fun onDestroy() = disposables.clear()

}