package com.example.githubrepo.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.data.models.PullRequestParams
import com.example.githubrepo.data.repository.GithubRepository
import com.example.githubrepo.domain.common.Result
import com.example.githubrepo.domain.usescases.GetClosedPullRequest
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val getClosedPullRequest = GetClosedPullRequest(GithubRepository())

    val closedPullRequests: MutableLiveData<ArrayList<PullRequest>> by lazy {
        MutableLiveData<ArrayList<PullRequest>>()
    }

    val isDataLoading = MutableLiveData(false)
    private var currentPage = 1
    private var username: String = "binaykumar123"
        set(value) {
            field = value
        }
    private var repo: String = "GithubRepo"
        set(value) {
            field = value
        }

    fun fetchAllClosedRequest() {
        viewModelScope.launch {
            isDataLoading.postValue(true)
            val closedPullRequestResult = getClosedPullRequest(
                PullRequestParams(username, repo, currentPage)
            )
            when (closedPullRequestResult) {
                is Result.Success -> {
                    when {
                        closedPullRequests.value == null -> {
                            closedPullRequests.postValue(closedPullRequestResult.data)
                        }
                        closedPullRequests.value!!.isEmpty() -> {
                            closedPullRequests.postValue(closedPullRequestResult.data)
                        }
                        else -> {
                            val existingElements = closedPullRequests.value
                            existingElements?.addAll(closedPullRequestResult.data)
                            closedPullRequests.postValue(existingElements)
                        }
                    }
                    increasePageNumber()
                }
                is Result.ApiError -> {

                }
                else -> {

                }
            }
            isDataLoading.postValue(false)
        }
    }

    private fun increasePageNumber() {
        currentPage++
    }

    override fun onCleared() {
        super.onCleared()
    }
}