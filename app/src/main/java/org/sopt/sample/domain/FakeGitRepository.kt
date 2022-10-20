package org.sopt.sample.domain

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.json.JSONArray
import org.json.JSONException
import org.sopt.sample.domain.model.FakeGitItem
import org.sopt.sample.presentation.home.model.GitData

fun Context.getJsonData(): List<GitData> {
// Repository 라는 이름이랑 내부 동작을 이런식으로 쓰는게 맞는건지 모르겠습니다..
    val assetManager = resources.assets
    val jsonArray = JSONArray(
        assetManager.open("fake_repo_list.json").bufferedReader().use { it.readText() })
    val fakeRepoList: MutableList<GitData> = mutableListOf()
    repeat(jsonArray.length())
    {
        try {
            val element = Json.parseToJsonElement(jsonArray.get(it).toString())
            val fakeGitData = Json.decodeFromJsonElement<FakeGitItem>(element)
            fakeRepoList.add(
                GitData( // repo id , 이미지 uri , repo 이름, repo 주인
                    fakeGitData.id!!,
                    fakeGitData.owner!!.avatarUrl!!,
                    fakeGitData.name!!,
                    fakeGitData.owner.login!!
                )
            )
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    return fakeRepoList
}

