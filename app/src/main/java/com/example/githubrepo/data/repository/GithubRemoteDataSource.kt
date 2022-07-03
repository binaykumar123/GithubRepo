package com.example.githubrepo.data.repository

import com.example.githubrepo.data.models.PullRequest
import retrofit2.Response

interface GithubRemoteDataSource {
    suspend fun getClosedPullRequest(username: String, repo: String): Response<List<PullRequest>>
}