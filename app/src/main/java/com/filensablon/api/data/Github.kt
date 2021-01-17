package com.filensablon.api.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Github {
    @GET("search/users")
    @Headers("Authorization: token a26bc8a926f93bebca23312459bc6d81fe33e48b")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token a26bc8a926f93bebca23312459bc6d81fe33e48b")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<NewsUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token a26bc8a926f93bebca23312459bc6d81fe33e48b")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token a26bc8a926f93bebca23312459bc6d81fe33e48b")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}