package org.sopt.sample.presentation.util

import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.makeSnackbar(messgae: String) {
    Snackbar.make(
        this,
        messgae, Snackbar.LENGTH_SHORT
    ).show()
}

fun View.makeToast(messgae: String) {
    Toast.makeText(
        this.context, messgae, Toast.LENGTH_SHORT
    ).show()
}

