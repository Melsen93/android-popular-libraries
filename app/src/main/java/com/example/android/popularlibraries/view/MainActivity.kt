package com.example.android.popularlibraries.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.popularlibraries.databinding.ActivityMainBinding
import com.example.android.popularlibraries.presenter.MainPresenter
import com.example.android.popularlibraries.utils.Numbers

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonClickListener()
    }

    private fun setButtonClickListener() {
        binding.buttonCounter1.setOnClickListener {
            presenter.counterClick(Numbers.ONE)
        }
        binding.buttonCounter2.setOnClickListener {
            presenter.counterClick(Numbers.TWO)
        }
        binding.buttonCounter3.setOnClickListener {
            presenter.counterClick(Numbers.THREE)
        }
    }

    override fun setButton1Text(text: String) {
        binding.buttonCounter1.text = text
    }

    override fun setButton2Text(text: String) {
        binding.buttonCounter2.text = text
    }

    override fun setButton3Text(text: String) {
        binding.buttonCounter3.text = text
    }

}