package org.sopt.sample.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RequestLoginDTO(
    // JSON 객체로 변환될 때 'email': 'nunu.lee@gmail.com' 과 같은 식으로 들어갈 수 있다는 표기
    @SerialName("email") // Json에서 응답객체로 넣어줄 key를 SerialName("key")로 넣어주는 것이다.
    // Annotation을 넣어주는 이유 예룰들어 pass_word이런식으로 코틀린 convention을 따라가지 않는 경우를 방지 하기 위해서
    // 다음과 같이 annotation을 이용하여 SerialName annotation이 없어진다.
    val email: String,
    @SerialName("password")
    val password: String,
)