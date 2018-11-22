package com.gmail.ortuchr.data.local.database

import com.gmail.ortuchr.data.entity.StudentResponse
import com.gmail.ortuchr.data.local.entity.StudentDb
import com.gmail.ortuchr.domain.entity.hw11.Student

fun StudentDb.transformToDomain(): Student {
    return Student(id = id, name = name, age = age, url = url)
}

fun StudentResponse.transformToDb(): StudentDb {
    return StudentDb(id = id, name = name, age = age, url = url)
}