package com.gmail.ortuchr.data.entity

import com.gmail.ortuchr.domain.entity.hw11.Student

fun StudentResponse.transformToDomain() : Student {
    return Student(id = id, name = name, age = age, url = url)
}