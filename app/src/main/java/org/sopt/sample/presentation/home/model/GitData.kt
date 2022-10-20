package org.sopt.sample.presentation.home.model

data class GitData(
    val id: Int,
    val img: String,
    val name: String,
    val des: String,
    val viewType: Int = 1
) {
    //기본적으로는 Header가 아닌 Item viewType
}
