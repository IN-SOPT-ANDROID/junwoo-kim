package org.sopt.sample.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//해당 클래스는 http://3.39.169.52:3000  POST api/user/signin한 결과
@Serializable
data class ResponseLoginDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: User
) {
    @Serializable
    data class User(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
        @SerialName("profileImage")
        val profileImage: String?,
        @SerialName("bio")
        val bio: String?,
        @SerialName("email")
        val email: String,
        @SerialName("password")//패스워드가 평문으로 넘어오는 것이므로 별로 좋지 않은 API
        val password: String,
    )
}