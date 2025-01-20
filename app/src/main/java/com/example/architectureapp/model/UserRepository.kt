package com.example.architectureapp.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architectureapp.model.data.User
import com.example.architectureapp.model.network.MyApiClient
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class UserRepository(){
    private val apiClient = MyApiClient.create()

    fun getUsers(): LiveData<List<User>> {
        val users = MutableLiveData<List<User>>()
        apiClient.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    users.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })
        return users
    }
}