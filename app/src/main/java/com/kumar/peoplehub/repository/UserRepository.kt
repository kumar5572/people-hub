package com.kumar.peoplehub.repository

import com.kumar.peoplehub.model.User
import com.kumar.peoplehub.network.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}