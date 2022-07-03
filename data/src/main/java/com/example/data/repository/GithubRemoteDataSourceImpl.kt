package com.example.data.repository

import com.example.data.apiservice.ApiService
import com.example.data.apiservice.RetrofitHelper
import com.example.data.models.PullRequest
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