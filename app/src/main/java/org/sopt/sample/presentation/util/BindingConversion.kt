package org.sopt.sample.presentation.util

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import org.sopt.sample.R

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("app:touch_gitItem")
fun touch(view: TextView, selected:Boolean){
    if (selected) {
        view.typeface = ResourcesCompat.getFont(view.context, R.font.nanumgothicextrabold)
        view.setCompoundDrawablesWithIntrinsicBounds(
            null, null, view.context.getDrawable(R.drawable.ic_check), null
        )
    } else {
        view.typeface = ResourcesCompat.getFont(view.context, R.font.nanumgothicbold)
        view.setCompoundDrawables(null, null, null, null)
    }
}