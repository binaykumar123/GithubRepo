package com.example.githubrepo.data.models

data class PullRequestParams(
    val userName: String,
    val repo: String,
    val page: Int,
    val state: String = "closed",
    val perPage: Int = 10
)