package org.sopt.sample.presentation.home.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    @SerialName("avatar_url")
    val avatarUrl: String?, // https://avatars.githubusercontent.com/u/70648111?v=4
    @SerialName("events_url")
    val eventsUrl: String?, // https://api.github.com/users/IslandofDream/events{/privacy}
    @SerialName("followers_url")
    val followersUrl: String?, // https://api.github.com/users/IslandofDream/followers
    @SerialName("following_url")
    val followingUrl: String?, // https://api.github.com/users/IslandofDream/following{/other_user}
    @SerialName("gists_url")
    val gistsUrl: String?, // https://api.github.com/users/IslandofDream/gists{/gist_id}
    @SerialName("gravatar_id")
    val gravatarId: String?,
    @SerialName("html_url")
    val htmlUrl: String?, // https://github.com/IslandofDream
    @SerialName("id")
    val id: Int?, // 70648111
    @SerialName("login")
    val login: String?, // IslandofDream
    @SerialName("node_id")
    val nodeId: String?, // MDQ6VXNlcjcwNjQ4MTEx
    @SerialName("organizations_url")
    val organizationsUrl: String?, // https://api.github.com/users/IslandofDream/orgs
    @SerialName("received_events_url")
    val receivedEventsUrl: String?, // https://api.github.com/users/IslandofDream/received_events
    @SerialName("repos_url")
    val reposUrl: String?, // https://api.github.com/users/IslandofDream/repos
    @SerialName("site_admin")
    val siteAdmin: Boolean?, // false
    @SerialName("starred_url")
    val starredUrl: String?, // https://api.github.com/users/IslandofDream/starred{/owner}{/repo}
    @SerialName("subscriptions_url")
    val subscriptionsUrl: String?, // https://api.github.com/users/IslandofDream/subscriptions
    @SerialName("type")
    val type: String?, // User
    @SerialName("url")
    val url: String? // https://api.github.com/users/IslandofDream
)