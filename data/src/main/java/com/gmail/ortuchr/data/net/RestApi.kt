package com.gmail.ortuchr.data.net

import com.gmail.ortuchr.data.entity.*
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface RestApi {

    @GET("Students?sortBy=name")
    fun getStudents() : Observable<List<StudentResponse>>

    @GET("Students/{id}")
    fun getStudentsById(@Path("id") id: String) : Observable<StudentResponse>

    @PUT("Students/{id}")
    fun updateStudent(@Path("id") id: String,
                      @Body student: StudentRequest) : Completable

    @DELETE("Students/{id}")
    fun deleteStudent(@Path("id") id: String) : Completable

    @POST("Students")
    fun addStudent(@Body student: StudentAddRequest) : Observable<StudentResponse>

    @GET("Students")
    fun searchStudents(@Query("where") search: String) : Observable<List<StudentResponse>>
}