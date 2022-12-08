package org.sopt.sample.domain.repository

interface SharedPrefRepository {
    fun checkLogin(): Boolean
    fun setLoginInfo(id: String, pw: String, name: String)
}