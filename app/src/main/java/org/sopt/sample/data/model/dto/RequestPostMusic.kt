package org.sopt.sample.data.model.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPostMusic(
    @SerialName("singer")
    val singer: String, // BOL4
    @SerialName("title")
    val title: String // Seoul
)