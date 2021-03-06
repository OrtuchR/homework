package com.gmail.ortuchr.data.entity

import com.google.gson.annotations.SerializedName

data class StudentAddRequest (
        @SerializedName("name")
        val name: String,

        @SerializedName("age")
        val age: Int,

        @SerializedName("url")
        val url: String
) : DataEntity