package com.gmail.ortuchr.domain.usecases.hw11

import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import com.gmail.ortuchr.domain.usecases.BaseUseCase
import io.reactivex.Completable

class AddStudentUseCase(private val studentRepository: StudentRepository) : BaseUseCase() {

    fun add(addStudent: StudentAdd) : Completable {
        return studentRepository.add(addStudent)
    }
}