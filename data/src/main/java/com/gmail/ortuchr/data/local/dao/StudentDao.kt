package com.gmail.ortuchr.data.local.dao

import android.arch.persistence.room.*
import com.gmail.ortuchr.data.entity.StudentAddRequest
import com.gmail.ortuchr.data.entity.StudentRequest
import com.gmail.ortuchr.data.local.entity.StudentDb
import io.reactivex.Completable
import io.reactivex.Flowable
import android.arch.persistence.room.OnConflictStrategy



@Dao
interface StudentDao {
    @Query("SELECT * FROM students ORDER BY name")
    fun get(): Flowable<List<StudentDb>>

    @Query("SELECT * FROM students WHERE id = :id LIMIT 1")
    fun get(id: String): Flowable<StudentDb>

    @Query("SELECT * FROM students WHERE name LIKE :search")
    fun search(search: String): Flowable<List<StudentDb>>

    /*@Insert
    fun update(student: StudentRequest): Completable

    @Query("DELETE FROM students WHERE id = :deleteID")
    fun delete(deleteID: String): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(add: StudentDb)*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(listStudents: List<StudentDb>)

    @Query("DELETE FROM students")
    fun deleteAll()
}