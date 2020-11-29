package com.rsc.assignment247.service

import com.rsc.assignment247.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("public-api/users")
    fun getUserDetails(): Call<UserResponse>

}