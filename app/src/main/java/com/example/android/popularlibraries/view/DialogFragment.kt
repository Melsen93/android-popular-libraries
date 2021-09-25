package com.example.android.popularlibraries.view

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.android.popularlibraries.R

class DialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(getString(R.string.convert))
                .setPositiveButton(getString(R.string.cont)) { dialog, _ ->
                    dialog.cancel()
                }
                .setNegativeButton(getString(R.string.abort)) { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException(getString(R.string.errorDialog))
    }

}