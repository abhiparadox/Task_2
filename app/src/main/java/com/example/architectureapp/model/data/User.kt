package com.example.architectureapp.model.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id:Int,val name:String,val username: String,val email:String
):Parcelable