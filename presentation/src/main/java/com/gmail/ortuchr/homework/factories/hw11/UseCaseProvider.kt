package com.gmail.ortuchr.homework.factories.hw11

import com.gmail.ortuchr.data.local.database.AppDataBase
import com.gmail.ortuchr.data.net.RestService
import com.gmail.ortuchr.data.repositories.hw11.StudentRepositorySinglton
import com.gmail.ortuchr.data.repositories.hw12.StudentRepositoryImpl
import com.gmail.ortuchr.domain.usecases.hw11.*
import com.gmail.ortuchr.homework.app.App
import com.gmail.ortuchr.homework.executor.UIThread

object UseCaseProvider {

    //класс для реализации REST
    val restService = RestService("https://api.backendless.com/8A8931EE-80C0-736E-FF8A-AF02D4EBA700/5F55FD93-0008-AE91-FF06-39E4E75E8300/data/")

    //Реализация интерфейса их домена, что бы сказать UseCase в каком потоке получать ответ
    val uiThread = UIThread()

    val studentDao = AppDataBase.getDatabase(App.instance.applicationContext)
            .getStudentDao()

    fun provideGetStudentListUseCase(): GetStudentsUseCase {
        return GetStudentsUseCase(uiThread, StudentRepositoryImpl(restService, studentDao))
    }

    fun provideSearchStudentUseCase(): SearchStudentsUseCase {
        return SearchStudentsUseCase(uiThread, StudentRepositoryImpl(restService, studentDao))
    }

    fun provideGetSimpleStudentUseCase(): GetSimpleStudentUseCase {
        return GetSimpleStudentUseCase(uiThread, StudentRepositoryImpl(restService, studentDao))
    }

    fun provideAddStudentUseCase(): AddStudentUseCase {
        return AddStudentUseCase(uiThread, StudentRepositoryImpl(restService, studentDao))
    }

    fun provideUpdateStudentUseCase(): UpdateStudentUseCase {
        return UpdateStudentUseCase(uiThread, StudentRepositoryImpl(restService, studentDao))
    }

    fun provideDeleteStudentUseCase(): DeleteStudentUseCase {
        return DeleteStudentUseCase(uiThread, StudentRepositoryImpl(restService, studentDao))
    }
}