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
fun textviewtouch(view: TextView, selected:Boolean){
    if (selected) {
        view.typeface = ResourcesCompat.getFont(view.context, R.font.nanumgothicextrabold)
    } else {
        view.typeface = ResourcesCompat.getFont(view.context, R.font.nanumgothicbold)
    }
}

@SuppressLint("ResourceAsColor")
@BindingAdapter("app:layout_touch_gitItem")
fun layouttouch(view: ConstraintLayout, selected:Boolean){
    if (selected) {
        view.setBackgroundColor(Color.parseColor("#808080"))
    } else {
        view.setBackgroundColor(Color.parseColor("#FFFFFF"))
    }
}

