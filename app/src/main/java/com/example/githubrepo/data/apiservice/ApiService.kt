package com.example.githubrepo.data.apiservice

import com.example.githubrepo.data.models.PullRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/repos/{username}/{repo}/pulls")
    suspend fun getClosedPullRequest(
        @Path("username") username: String,
        @Path("repo") repo: String,
        @Query("page") page: Int,
        @Query("state") state: String = "closed",
        @Query("per_page") perPage: Int = 10,
    ): Response<ArrayList<PullRequest>>
}