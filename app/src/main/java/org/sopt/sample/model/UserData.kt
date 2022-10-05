package org.sopt.sample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(val id: String, val pw: String, val mbti: String) : Parcelable