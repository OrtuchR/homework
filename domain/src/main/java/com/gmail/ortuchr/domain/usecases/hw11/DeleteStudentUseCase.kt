package com.gmail.ortuchr.domain.usecases.hw11

import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.executor.PostExecutorThread
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import com.gmail.ortuchr.domain.usecases.BaseUseCase
import io.reactivex.Completable

class DeleteStudentUseCase(
        postExecutorThread: PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {

    fun delete(deleteStudent: StudentDelete) : Completable {
        return studentRepository.delete(deleteStudent)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}