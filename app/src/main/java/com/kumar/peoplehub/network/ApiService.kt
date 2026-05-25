package com.kumar.peoplehub.network

import com.kumar.peoplehub.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}