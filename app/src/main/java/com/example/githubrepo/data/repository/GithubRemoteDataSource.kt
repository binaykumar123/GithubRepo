package com.example.githubrepo.data.repository

import com.example.githubrepo.data.apiservice.ApiService
import com.example.githubrepo.data.apiservice.RetrofitHelper
import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.data.models.PullRequestParams
import retrofit2.Response

class GithubRemoteDataSource {

    private val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

    suspend fun getClosedPullRequest(
        pullRequestParams: PullRequestParams
    ): Response<ArrayList<PullRequest>> {
        return apiService.getClosedPullRequest(
            pullRequestParams.userName,
            pullRequestParams.repo,
            pullRequestParams.page,
        )
    }
}
