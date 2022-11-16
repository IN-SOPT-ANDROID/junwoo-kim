package org.sopt.sample.data.model.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReqresList(
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("page")
    val page: Int, // 2
    @SerialName("per_page")
    val perPage: Int, // 6
    @SerialName("support")
    val support: Support,
    @SerialName("total")
    val total: Int, // 12
    @SerialName("total_pages")
    val totalPages: Int // 2
) {
    @Serializable
    data class Support(
        @SerialName("text")
        val text: String, // To keep ReqRes free, contributions towards server costs are appreciated!
        @SerialName("url")
        val url: String // https://reqres.in/#support-heading
    )

    @Serializable
    data class Data(
        @SerialName("avatar")
        val avatar: String, // https://reqres.in/img/faces/7-image.jpg
        @SerialName("email")
        val email: String, // michael.lawson@reqres.in
        @SerialName("first_name")
        val firstName: String, // Michael
        @SerialName("id")
        val id: Int, // 7
        @SerialName("last_name")
        val lastName: String // Lawson
    )
}
