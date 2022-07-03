package com.example.githubrepo.domain.usescases

import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.domain.common.Result
import com.example.githubrepo.domain.repository.GithubRepository

class GetClosedPullRequest(private val githubRepository: GithubRepository) : BaseUseCase() {

    suspend operator fun invoke(
        username: String,
        repo: String
    ): Result<List<PullRequest>> {
        val response = githubRepository.getClosedPullRequests(username, repo)
        if (response.isSuccessful && response.body() != null) {
            return Result.success(response.body()!!)
        }
        return Result.apiError(response.message() ?: "")
    }
}