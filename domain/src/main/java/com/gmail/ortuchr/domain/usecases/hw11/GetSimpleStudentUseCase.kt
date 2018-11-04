package com.gmail.ortuchr.domain.usecases.hw11

import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import com.gmail.ortuchr.domain.usecases.BaseUseCase
import io.reactivex.Observable

class GetSimpleStudentUseCase(private val studentRepository: StudentRepository) : BaseUseCase() {

    fun get(id: String): Observable<Student> {
        return studentRepository.get(id)
    }
}