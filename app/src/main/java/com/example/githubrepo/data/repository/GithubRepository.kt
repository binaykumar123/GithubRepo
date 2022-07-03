package com.example.githubrepo.data.repository

import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.data.models.PullRequestParams
import retrofit2.Response

class GithubRepository() {
    private val remoteDataSource = GithubRemoteDataSource()
    suspend fun getClosedPullRequests(
        pullRequestParams: PullRequestParams
    ): Response<ArrayList<PullRequest>> {
        return remoteDataSource.getClosedPullRequest(
            pullRequestParams
        )
    }
}