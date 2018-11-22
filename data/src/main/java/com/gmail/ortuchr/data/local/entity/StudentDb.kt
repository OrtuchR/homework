package com.gmail.ortuchr.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "students")
data class StudentDb(
        @PrimaryKey
        val id: String,

        val name: String,

        val age: Int,

        val url: String
)