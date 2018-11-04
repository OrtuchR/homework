package com.gmail.ortuchr.data.net

import com.gmail.ortuchr.data.entity.StudentDeleteRequest
import com.gmail.ortuchr.data.entity.StudentRequest
import com.gmail.ortuchr.data.entity.StudentResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {

    @GET("students")
    fun getStudents() : Observable<List<StudentResponse>>

    // https://tut.by/api/students?id=dsfsdf
    @GET("students")
    fun getStudentsById(@Query("id") id: String) : Observable<StudentResponse>

    // https://tut.by/api/students/21321/
    @GET("students/{id}/")
    fun getStudentsById2(@Path("id") id: String) : Observable<StudentResponse>

    // https://tut.by/api/students
    @POST("students")
    fun updateStudent(@Body student: StudentRequest) : Observable<StudentResponse>

    // https://tut.by/api/students/21321/
    @POST("students/{id}/")
    fun updateStudent(@Path("id") id: String,
                      @Body student: StudentRequest) : Observable<StudentResponse>

    // https://tut.by/api/students/21321/
    @DELETE("students/{id}/")
    fun deleteStudent(@Path("id") id: String) : Observable<Void>

    // https://tut.by/api/students
    @DELETE("students")
    fun deleteStudent(@Body student: StudentDeleteRequest) : Observable<Void>
}