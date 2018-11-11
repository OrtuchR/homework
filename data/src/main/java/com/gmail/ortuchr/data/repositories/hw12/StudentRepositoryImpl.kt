package com.gmail.ortuchr.data.repositories.hw12

import android.os.SystemClock
import android.util.Log
import com.gmail.ortuchr.data.entity.*
import com.gmail.ortuchr.data.net.RestService
import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable

class StudentRepositoryImpl(val apiService: RestService) : StudentRepository {

    override fun get(): Observable<List<Student>> {
        return apiService.getStudents()
                .map {
                    it.map { student ->
                        student.transformToDomain() }
                }
    }

    override fun get(id: String): Observable<Student> {
        return apiService.getStudentById(id)
                .map {
                    it.transformToDomain()
                }
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        return apiService.searchStudents(search.transformToSearchRequest())
                .map {
                    it.map { student ->
                        student.transformToDomain()
                    }
                }
    }

    override fun update(student: Student): Completable {
        return apiService.updateStudent(student.transformToRequest())
    }

    override fun delete(delete: StudentDelete): Completable {
        return apiService.deleteStudent(delete.transformToDeleteRequest())
    }

    override fun add(add: StudentAdd): Completable {
        return apiService.addStudent(add.transformToAddRequest())
    }
}