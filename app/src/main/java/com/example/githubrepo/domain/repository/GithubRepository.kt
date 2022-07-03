package com.example.githubrepo.domain.repository

import com.example.githubrepo.data.models.PullRequest
import retrofit2.Response

interface GithubRepository {
    suspend fun getClosedPullRequests(
        username: String,
        repo: String
    ): Response<List<PullRequest>>
}