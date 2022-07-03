package com.example.data.apiservice

import com.example.data.models.PullRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/repos/{username}/{repo}/pulls")
    suspend fun getClosedPullRequest(@Path("username") username: String, repo: String): Response<List<PullRequest>>
}