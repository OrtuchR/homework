package com.gmail.ortuchr.data.repositories.hw12

import com.gmail.ortuchr.data.entity.*
import com.gmail.ortuchr.data.local.dao.StudentDao
import com.gmail.ortuchr.data.local.database.transformToDb
import com.gmail.ortuchr.data.local.database.transformToDomain
import com.gmail.ortuchr.data.net.RestService
import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable
import kotlin.coroutines.experimental.coroutineContext

class StudentRepositoryImpl(
        val apiService: RestService,
        val studentDao: StudentDao) : StudentRepository {

    companion object {
        const val TIME_BUFFER = 3600000
        private var lastTimeUpdate = 0L
    }


    override fun get(): Observable<List<Student>> {
        return studentDao.get()
                .take(1)
                .toObservable()
                .flatMap { listStudentDb ->
                    apiService.getStudents()
                            .doOnNext { listStudentResponse ->
                                if (listStudentDb.isEmpty() || System.currentTimeMillis() - lastTimeUpdate > TIME_BUFFER) {
                                    studentDao.deleteAll()
                                    val list = listStudentResponse.map { it.transformToDb() }
                                    studentDao.addAll(list)
                                    lastTimeUpdate = System.currentTimeMillis()
                                    //.map { studentDao.add(it) }
                                }
                            }
                            .map { listStudentResponse ->
                                listStudentResponse.map { it.transformToDomain() }
                            }
                            .onErrorReturn {
                                if (listStudentDb.isEmpty()) {
                                    throw it
                                } else {
                                    listStudentDb
                                            .map { studentDb ->
                                                studentDb.transformToDomain()
                                            }
                                }
                            }
                }
    }

    override fun get(id: String): Observable<Student> {
        return studentDao.get(id)
                .take(1)
                .toObservable()
                .flatMap { studentDb ->
                    apiService.getStudentById(id)
                            .map { studentResponse ->
                                studentResponse.transformToDomain()
                            }
                            .onErrorReturn {
                                if (studentDb.id.isEmpty()) {
                                    throw it
                                } else {
                                    studentDb.transformToDomain()
                                }
                            }
                }
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        return studentDao.search(search.name + "%")
                .take(1)
                .toObservable()
                .flatMap { listStudentDb ->
                    apiService.searchStudents(search.transformToSearchRequest())
                            .map {
                                it.map { student ->
                                    student.transformToDomain()
                                }
                            }
                            .onErrorReturn {
                                if (listStudentDb.isEmpty()) {
                                    listStudentDb
                                            .map { studentDb ->
                                                studentDb.transformToDomain()
                                            }
                                } else {
                                    listStudentDb
                                            .map { studentDb ->
                                                studentDb.transformToDomain()
                                            }
                                }
                            }
                }
    }

    override fun update(student: Student): Completable {
        return apiService.updateStudent(student.transformToRequest())
    }

    override fun delete(delete: StudentDelete): Completable {
        return apiService.deleteStudent(delete.transformToDeleteRequest())
    }

    override fun add(add: StudentAdd): Observable<Student> {
        return apiService.addStudent(add.transformToAddRequest())
                .map {
                    it.transformToDomain()
                }
    }
}