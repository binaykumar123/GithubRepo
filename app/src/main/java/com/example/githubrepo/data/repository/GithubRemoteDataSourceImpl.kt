package com.example.githubrepo.data.repository

import com.example.githubrepo.data.apiservice.ApiService
import com.example.githubrepo.data.apiservice.RetrofitHelper
import com.example.githubrepo.data.models.PullRequest
import retrofit2.Response

class GithubRemoteDataSourceImpl : GithubRemoteDataSource {

    private val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

    override suspend fun getClosedPullRequest(
        username: String,
        repo: String
    ): Response<List<PullRequest>> {
        return apiService.getClosedPullRequest(username, repo)
    }
}