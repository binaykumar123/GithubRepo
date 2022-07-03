package com.example.githubrepo.data.models

import com.google.gson.annotations.SerializedName

data class PullRequest(
    val title: String,
    val user: User,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)

data class User(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
