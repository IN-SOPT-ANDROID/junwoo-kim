package org.sopt.sample.data.model.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePostMusicDTO(
    @SerialName("statusCode")
    val statusCode: Int, // 201
    @SerialName("success")
    val success: Boolean, // true
    @SerialName("message")
    val message: String, // 음악 생성에 성공했습니다.
    @SerialName("data")
    val `data`: Data
) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int, // 1
        @SerialName("image")
        val image: String, // https://sopt-31th-bucket.s3.ap-northeast-2.amazonaws.com/4d1c3bf5-2cca-4cb1-8ac2-6c90b684878e.png
        @SerialName("title")
        val title: String, // 아요미들
        @SerialName("singer")
        val singer: String // 한솔
    )
}