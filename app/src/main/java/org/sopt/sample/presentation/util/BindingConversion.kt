package org.sopt.sample.presentation.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.sopt.sample.R

@BindingAdapter("app:textView_touch_gitItem")
fun TextView.textviewtouch(selected: Boolean) {
    if (selected) {
        typeface = ResourcesCompat.getFont(context, R.font.nanumgothicextrabold)
    } else {
        typeface = ResourcesCompat.getFont(context, R.font.nanumgothicbold)
    }
}

@SuppressLint("ResourceAsColor")
@BindingAdapter("app:layout_touch_gitItem")
fun ConstraintLayout.layouttouch(selected: Boolean) {
    if (selected) {
        setBackgroundColor(Color.parseColor("#D3D3D3"))
    } else {
        setBackgroundColor(Color.parseColor("#FFFFFF"))
    }
}

@BindingAdapter("app:profile_load")
fun ImageView.loadprofile(url: String) {
    if (url == "") {
        Glide.with(context)
            .load(R.drawable.ic_github)
            .circleCrop()
            .into(this)

    } else {
        Glide.with(context)
            .load(url)
            .circleCrop()
            .error(R.drawable.ic_github)
            .into(this)
    }
}

@BindingAdapter("app:reqres_profile_load")
fun ImageView.loadreqresprofile(url: String) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_image_not_supported)
        .into(this)
}

