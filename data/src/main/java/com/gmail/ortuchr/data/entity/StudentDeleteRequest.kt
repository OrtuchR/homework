package com.gmail.ortuchr.data.entity

import com.google.gson.annotations.SerializedName

data class StudentDeleteRequest(
        @SerializedName("objectId")
        val id: String
) : DataEntity