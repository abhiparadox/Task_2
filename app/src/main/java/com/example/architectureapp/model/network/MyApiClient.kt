package com.example.architectureapp.model.network

import com.example.architectureapp.model.data.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface MyApiClient{
    @GET("users")
    fun getUsers():Call<List<User>>

    companion object {
        fun create():MyApiClient{
            val retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
            return retrofit.create(MyApiClient::class.java)
        }
    }
}