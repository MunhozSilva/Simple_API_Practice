package com.example.simpleapipractice.repository

import com.example.simpleapipractice.api.RetrofitInstance
import com.example.simpleapipractice.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}