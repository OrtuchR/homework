package com.gmail.ortuchr.data.entity

import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch

fun StudentResponse.transformToDomain() : Student {
    return Student(id = id, name = name, age = age, url = url)
}

fun Student.transformToRequest() : StudentRequest {
    return StudentRequest(id = id, name = name, age = age, url = url)
}

fun StudentAdd.transformToAddRequest() : StudentAddRequest {
    return StudentAddRequest(name = name, age = age, url = url)
}

fun StudentDelete.transformToDeleteRequest() : StudentDeleteRequest {
    return StudentDeleteRequest(id = id)
}

fun StudentSearch.transformToSearchRequest() : StudentSearchRequest {
    return StudentSearchRequest(name = name)
}

fun transformToSearchName(search: String) : String {
    return "name LIKE '$search%'"
}

