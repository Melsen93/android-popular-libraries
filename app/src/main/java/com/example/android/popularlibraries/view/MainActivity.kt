package com.example.android.popularlibraries.view

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.popularlibraries.R
import com.example.android.popularlibraries.databinding.ActivityMainBinding
import com.example.android.popularlibraries.presenter.MainPresenter
import com.example.android.popularlibraries.presenter.MainPresenterImpl
import com.example.android.popularlibraries.presenter.MainView
import com.example.android.popularlibraries.repository.RepositoryImpl

class MainActivity : AppCompatActivity(), MainView {

    companion object {
        const val IMAGE_URI = "IMAGE_URI"
    }

    private lateinit var binding: ActivityMainBinding

    private var uri: Uri? = null
    private val presenter: MainPresenter = MainPresenterImpl(this, RepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            savedInstanceState?.let {
                val stringUri = savedInstanceState.getString(IMAGE_URI)
                uri = Uri.parse(stringUri)
                uri?.let { imageView.setImageURI(uri) }
            }

            buttonConvert.setOnClickListener {
                presenter.readAndShowJPG()
                presenter.showConvertDialog()
            }
        }
        presenter.saveJPGFile()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(IMAGE_URI, uri.toString())
    }

    override fun showError(message: String) {
        Toast.makeText(this, resources.getString(R.string.error) + message, Toast.LENGTH_LONG)
            .show()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showDialog() {
        DialogFragment().show(supportFragmentManager, "dialog")
    }

    override fun showJPGImage(uriString: String) {
        uri = Uri.parse(uriString)
        binding.imageView.setImageURI(uri)
    }

}