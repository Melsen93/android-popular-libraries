package com.example.android.popularlibraries.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android.popularlibraries.databinding.ActivityMainBinding
import com.example.android.popularlibraries.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        binding.buttonCounter1.setOnClickListener(listener)
        binding.buttonCounter2.setOnClickListener(listener)
        binding.buttonCounter3.setOnClickListener(listener)
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> binding.buttonCounter1.text = text
            1 -> binding.buttonCounter2.text = text
            2 -> binding.buttonCounter3.text = text
        }
    }

}