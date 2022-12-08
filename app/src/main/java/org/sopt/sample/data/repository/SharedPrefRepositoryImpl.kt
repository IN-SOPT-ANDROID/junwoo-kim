package org.sopt.sample.data.repository

import android.annotation.SuppressLint
import android.content.SharedPreferences
import org.sopt.sample.data.util.Constant
import org.sopt.sample.domain.repository.SharedPrefRepository
import javax.inject.Inject

class SharedPrefRepositoryImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    SharedPrefRepository {
    override fun checkLogin(): Boolean {
        return (sharedPreferences.getString(Constant.PREF_ID, null) == null)
    }

    @SuppressLint("CommitPrefEdits")
    override fun setLoginInfo(id: String, pw: String) {
        sharedPreferences.edit().apply {
            putString(Constant.PREF_ID, id)
            putString(Constant.PREF_PW, pw)
        }.apply()
    }
}