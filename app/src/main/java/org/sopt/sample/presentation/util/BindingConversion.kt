package org.sopt.sample.presentation.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import org.sopt.sample.R

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("app:textView_touch_gitItem")
fun TextView.textviewtouch(selected:Boolean){
    if (selected) {
        typeface = ResourcesCompat.getFont(context, R.font.nanumgothicextrabold)
    } else {
        typeface = ResourcesCompat.getFont(context, R.font.nanumgothicbold)
    }
}

@SuppressLint("ResourceAsColor")
@BindingAdapter("app:layout_touch_gitItem")
fun ConstraintLayout.layouttouch(selected:Boolean){
    if (selected) {
        setBackgroundColor(Color.parseColor("#808080"))
    } else {
        setBackgroundColor(Color.parseColor("#FFFFFF"))
    }
}

