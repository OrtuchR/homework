package com.gmail.ortuchr.data.entity

import com.google.gson.annotations.SerializedName

data class StudentSearchRequest (
        @SerializedName("name")
        val name: String
) : DataEntity