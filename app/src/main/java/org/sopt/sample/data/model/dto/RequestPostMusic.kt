package org.sopt.sample.data.model.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPostMusic(
    @SerialName("image")
    val image: String,
    @SerialName("singer")
    val singer: String,
    @SerialName("title")
    val title: String
)