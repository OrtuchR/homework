package com.gmail.ortuchr.domain.usecases.hw11

import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.executor.PostExecutorThread
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import com.gmail.ortuchr.domain.usecases.BaseUseCase
import io.reactivex.Completable

class AddStudentUseCase(
        postExecutorThread: PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {

    fun add(addStudent: StudentAdd) : Completable {
        return studentRepository.add(addStudent)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}