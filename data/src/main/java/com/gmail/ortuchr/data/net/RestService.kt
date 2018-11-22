package com.gmail.ortuchr.data.net

import android.util.Log
import com.gmail.ortuchr.data.entity.*
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestService(private val apiUrl: String) {

    private val restApi: RestApi

    init {

        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor(HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))

        val gson = Gson()

        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()

        restApi = retrofit.create(RestApi::class.java)
    }

    fun getStudents() : Observable<List<StudentResponse>> {
        return restApi.getStudents()
    }

    fun getStudentById(id: String) : Observable<StudentResponse> {
        return restApi.getStudentsById(id)
    }

    fun updateStudent(student: StudentRequest) : Completable {
        return restApi.updateStudent(student.id, student)
    }

    fun deleteStudent(student: StudentDeleteRequest) : Completable {
        return restApi.deleteStudent(student.id)
    }

    fun addStudent(student: StudentAddRequest) : Observable<StudentResponse> {
        return restApi.addStudent(student)
    }

    fun searchStudents(student: StudentSearchRequest) : Observable<List<StudentResponse>> {
        return restApi.searchStudents(transformToSearchName(student.name))
    }
}