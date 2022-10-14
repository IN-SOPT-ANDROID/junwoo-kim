package org.sopt.sample.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FakeGitItem(
    @SerialName("allow_forking")
    val allowForking: Boolean?, // true
    @SerialName("archive_url")
    val archiveUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/{archive_format}{/ref}
    @SerialName("archived")
    val archived: Boolean?, // false
    @SerialName("assignees_url")
    val assigneesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/assignees{/user}
    @SerialName("blobs_url")
    val blobsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/git/blobs{/sha}
    @SerialName("branches_url")
    val branchesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/branches{/branch}
    @SerialName("clone_url")
    val cloneUrl: String?, // https://github.com/IslandofDream/Baekjoon_Practice.git
    @SerialName("collaborators_url")
    val collaboratorsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/collaborators{/collaborator}
    @SerialName("comments_url")
    val commentsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/comments{/number}
    @SerialName("commits_url")
    val commitsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/commits{/sha}
    @SerialName("compare_url")
    val compareUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/compare/{base}...{head}
    @SerialName("contents_url")
    val contentsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/contents/{+path}
    @SerialName("contributors_url")
    val contributorsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/contributors
    @SerialName("created_at")
    val createdAt: String?, // 2022-07-25T06:07:44Z
    @SerialName("default_branch")
    val defaultBranch: String?, // main
    @SerialName("deployments_url")
    val deploymentsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/deployments
    @SerialName("description")
    val description: String?, // This is a auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).
    @SerialName("disabled")
    val disabled: Boolean?, // false
    @SerialName("downloads_url")
    val downloadsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/downloads
    @SerialName("events_url")
    val eventsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/events
    @SerialName("fork")
    val fork: Boolean?, // false
    @SerialName("forks")
    val forks: Int?, // 0
    @SerialName("forks_count")
    val forksCount: Int?, // 0
    @SerialName("forks_url")
    val forksUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/forks
    @SerialName("full_name")
    val fullName: String?, // IslandofDream/Baekjoon_Practice
    @SerialName("git_commits_url")
    val gitCommitsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/git/commits{/sha}
    @SerialName("git_refs_url")
    val gitRefsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/git/refs{/sha}
    @SerialName("git_tags_url")
    val gitTagsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/git/tags{/sha}
    @SerialName("git_url")
    val gitUrl: String?, // git://github.com/IslandofDream/Baekjoon_Practice.git
    @SerialName("has_downloads")
    val hasDownloads: Boolean?, // true
    @SerialName("has_issues")
    val hasIssues: Boolean?, // true
    @SerialName("has_pages")
    val hasPages: Boolean?, // false
    @SerialName("has_projects")
    val hasProjects: Boolean?, // true
    @SerialName("has_wiki")
    val hasWiki: Boolean?, // true
    @SerialName("homepage")
    val homepage: String?,
    @SerialName("hooks_url")
    val hooksUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/hooks
    @SerialName("html_url")
    val htmlUrl: String?, // https://github.com/IslandofDream/Baekjoon_Practice
    @SerialName("id")
    val id: Int?, // 517538898
    @SerialName("is_template")
    val isTemplate: Boolean?, // false
    @SerialName("issue_comment_url")
    val issueCommentUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/issues/comments{/number}
    @SerialName("issue_events_url")
    val issueEventsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/issues/events{/number}
    @SerialName("issues_url")
    val issuesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/issues{/number}
    @SerialName("keys_url")
    val keysUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/keys{/key_id}
    @SerialName("labels_url")
    val labelsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/labels{/name}
    @SerialName("language")
    val language: String?, // Kotlin
    @SerialName("languages_url")
    val languagesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/languages
    @SerialName("license")
    val license: String?, // null
    @SerialName("merges_url")
    val mergesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/merges
    @SerialName("milestones_url")
    val milestonesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/milestones{/number}
    @SerialName("mirror_url")
    val mirrorUrl: String?, // null
    @SerialName("name")
    val name: String?, // Baekjoon_Practice
    @SerialName("node_id")
    val nodeId: String?, // R_kgDOHtkEUg
    @SerialName("notifications_url")
    val notificationsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/notifications{?since,all,participating}
    @SerialName("open_issues")
    val openIssues: Int?, // 0
    @SerialName("open_issues_count")
    val openIssuesCount: Int?, // 0
    @SerialName("owner")
    val owner: Owner?,
    @SerialName("private")
    val `private`: Boolean?, // false
    @SerialName("pulls_url")
    val pullsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/pulls{/number}
    @SerialName("pushed_at")
    val pushedAt: String?, // 2022-10-02T12:05:45Z
    @SerialName("releases_url")
    val releasesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/releases{/id}
    @SerialName("size")
    val size: Int?, // 273
    @SerialName("ssh_url")
    val sshUrl: String?, // git@github.com:IslandofDream/Baekjoon_Practice.git
    @SerialName("stargazers_count")
    val stargazersCount: Int?, // 0
    @SerialName("stargazers_url")
    val stargazersUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/stargazers
    @SerialName("statuses_url")
    val statusesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/statuses/{sha}
    @SerialName("subscribers_url")
    val subscribersUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/subscribers
    @SerialName("subscription_url")
    val subscriptionUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/subscription
    @SerialName("svn_url")
    val svnUrl: String?, // https://github.com/IslandofDream/Baekjoon_Practice
    @SerialName("tags_url")
    val tagsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/tags
    @SerialName("teams_url")
    val teamsUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/teams
    @SerialName("topics")
    val topics: List<String?>?,
    @SerialName("trees_url")
    val treesUrl: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice/git/trees{/sha}
    @SerialName("updated_at")
    val updatedAt: String?, // 2022-07-27T07:54:45Z
    @SerialName("url")
    val url: String?, // https://api.github.com/repos/IslandofDream/Baekjoon_Practice
    @SerialName("visibility")
    val visibility: String?, // public
    @SerialName("watchers")
    val watchers: Int?, // 0
    @SerialName("watchers_count")
    val watchersCount: Int?, // 0
    @SerialName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean? // false
)