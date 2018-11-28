package com.gmail.ortuchr.data.net

import com.gmail.ortuchr.data.entity.ErrorResponse
import com.gmail.ortuchr.domain.entity.hw11.AppErrorType
import com.gmail.ortuchr.domain.entity.hw11.AppException
import com.google.gson.Gson
import io.reactivex.ObservableTransformer
import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException

class RestErrorParser(val gson: Gson) {
    fun <T> parseError(): ObservableTransformer<T, T> {
        return ObservableTransformer {observable ->
            observable
                    .onErrorReturn {throwable ->
                        when (throwable) {
                            is HttpException -> {
                                val errorBody = throwable.response().errorBody()?.string()
                                if (errorBody == null) {
                                    throw AppException(AppErrorType.UNKNOWN)
                                }
                                try {
                                    val errorObject = gson.fromJson<ErrorResponse>(
                                            errorBody,
                                            ErrorResponse::class.java)
                                    when (errorObject.errorCode) {
                                        123 -> {
                                            //incorrect id
                                            throw AppException(AppErrorType.INCORRECT_ID)
                                        }
                                        222 -> {
                                            //user blocked
                                            throw AppException(AppErrorType.BLOCKED)
                                        }
                                    }
                                } catch (e: Exception) {
                                    //send message to programmer
                                }
                                throw AppException(AppErrorType.UNKNOWN)
                            }
                            is SocketTimeoutException -> {
                                throw AppException(AppErrorType.SERVER_IS_NOT_AVAILABLE)
                            }
                            else -> {
                                throw AppException(AppErrorType.UNKNOWN)
                            }
                        }
                    }
        }
    }
}