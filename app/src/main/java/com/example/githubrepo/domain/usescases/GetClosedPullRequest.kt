package com.example.githubrepo.domain.usescases

import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.data.models.PullRequestParams
import com.example.githubrepo.data.repository.GithubRepository
import com.example.githubrepo.domain.common.Result
import com.example.githubrepo.presentation.fragment.PullRequestFragment

class GetClosedPullRequest(private val githubRepository: GithubRepository) : BaseUseCase() {

    suspend operator fun invoke(
        pullRequestParams: PullRequestParams
    ): Result<ArrayList<PullRequest>> {
        val response = githubRepository.getClosedPullRequests(pullRequestParams)

        if (response.isSuccessful && response.body() != null) {
            return Result.success(response.body()!!)
        }
        return Result.apiError(response.message() ?: "Something went wrong")
    }
}