package com.gmail.ortuchr.domain.usecases.hw11

import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
import com.gmail.ortuchr.domain.executor.PostExecutorThread
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import com.gmail.ortuchr.domain.usecases.BaseUseCase
import io.reactivex.Observable

class SearchStudentsUseCase(
        postExecutorThread: PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {

    fun search(searchStudent: StudentSearch): Observable<List<Student>> {
        return studentRepository.search(searchStudent)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}