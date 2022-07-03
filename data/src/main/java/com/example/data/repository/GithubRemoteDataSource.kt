package com.example.data.repository

import com.example.data.models.PullRequest
import retrofit2.Response
import retrofit2.http.Path

interface GithubRemoteDataSource {
    suspend fun getClosedPullRequest(username: String, repo: String): Response<List<PullRequest>>
}