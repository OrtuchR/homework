package com.gmail.ortuchr.domain.repositories.hw11

import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
import com.gmail.ortuchr.domain.repositories.BaseRepository
import io.reactivex.Completable
import io.reactivex.Observable

interface StudentRepository : BaseRepository {

    fun get(): Observable<List<Student>>

    fun get(id: String): Observable<Student>

    fun search(search: StudentSearch): Observable<List<Student>>

    fun update(student: Student): Completable

    fun delete(delete: StudentDelete): Completable

    fun add(add: StudentAdd): Completable
}