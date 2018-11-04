package com.gmail.ortuchr.data.entity

import com.google.gson.annotations.SerializedName

data class StudentResponse(

        @SerializedName("id")
        val id: String,
        val name: String,
        val age: Int,
        val url: String) : DataEntity