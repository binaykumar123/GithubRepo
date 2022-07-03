package com.example.githubrepo.data.repository

import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.domain.repository.GithubRepository
import retrofit2.Response

class GithubRepositoryImpl(
    private val remoteDataSource: GithubRemoteDataSource
) : GithubRepository {

    override suspend fun getClosedPullRequests(
        username: String,
        repo: String
    ): Response<List<PullRequest>> {
        return remoteDataSource.getClosedPullRequest(
            username,
            repo
        )
    }
}