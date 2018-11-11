package com.gmail.ortuchr.data.entity

import android.text.format.DateFormat
import com.google.gson.annotations.SerializedName

data class StudentResponse(
        @SerializedName("name")
        val name: String,

        @SerializedName("url")
        val url: String,

        @SerializedName("age")
        val age: Int,

        @SerializedName("objectId")
        val id: String
) : DataEntity