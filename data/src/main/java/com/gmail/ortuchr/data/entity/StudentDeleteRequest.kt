package com.gmail.ortuchr.data.entity

import com.google.gson.annotations.SerializedName

data class StudentDeleteRequest(
        @SerializedName("id")
        val id: String) : DataEntity