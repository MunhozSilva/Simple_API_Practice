package com.example.simpleapipractice.repository

import com.example.simpleapipractice.api.RetrofitInstance
import com.example.simpleapipractice.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}