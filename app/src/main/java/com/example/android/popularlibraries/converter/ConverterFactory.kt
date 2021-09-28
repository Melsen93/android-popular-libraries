package com.example.android.popularlibraries.converter

import android.content.Context

object ConverterFactory {

    fun create(context: Context): Converter = ConverterImpl(context)

}