package org.sopt.sample.data.model.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMusicDTO(
    @SerialName("statusCode")
    val statusCode: Int, // 200
    @SerialName("success")
    val success: Boolean, // true
    @SerialName("message")
    val message: String, // 음악 리스트 조회에 성공했습니다.
    @SerialName("data")
    val `data`: List<MusicData>
) {
    @Serializable
    data class MusicData(
        @SerialName("id")
        val id: Int, // 1
        @SerialName("image")
        val image: String, // https://sopt-31th-bucket.s3.ap-northeast-2.amazonaws.com/e3cbc3cd-f8c2-4cd5-bf45-49a10eb4ad36.jpeg
        @SerialName("title")
        val title: String, // 라일락
        @SerialName("singer")
        val singer: String // 아이유
    )
}