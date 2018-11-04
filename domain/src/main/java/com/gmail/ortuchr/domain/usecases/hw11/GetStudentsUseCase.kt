package com.gmail.ortuchr.domain.usecases.hw11

import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.executor.PostExecutorThread
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import com.gmail.ortuchr.domain.usecases.BaseUseCase
import io.reactivex.Observable

class GetStudentsUseCase(
        postExecutorThread: PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {

    fun get(): Observable<List<Student>> {
        return studentRepository.get()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}