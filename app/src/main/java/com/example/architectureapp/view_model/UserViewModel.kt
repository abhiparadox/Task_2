package com.example.architectureapp.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.architectureapp.model.UserRepository
import com.example.architectureapp.model.data.User

class UserViewModel:ViewModel(){
    private val repository = UserRepository()
    val users: LiveData<List<User>> = repository.getUsers()
}