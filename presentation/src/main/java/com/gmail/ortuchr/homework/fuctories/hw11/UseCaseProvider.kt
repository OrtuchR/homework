package com.gmail.ortuchr.homework.fuctories.hw11

import com.gmail.ortuchr.data.repositories.hw11.StudentRepositoryImpl
import com.gmail.ortuchr.domain.usecases.hw11.*

object UseCaseProvider {

    fun provideGetStudentListUseCase() : GetStudentsUseCase {
        return GetStudentsUseCase(StudentRepositoryImpl())
    }

    fun provideSearchStudentUseCase() : SearchStudentsUseCase {
        return SearchStudentsUseCase(StudentRepositoryImpl())
    }

    fun provideGetSimpleStudentUseCase() : GetSimpleStudentUseCase {
        return GetSimpleStudentUseCase(StudentRepositoryImpl())
    }

    fun provideAddStudentUseCase() : AddStudentUseCase {
        return AddStudentUseCase(StudentRepositoryImpl())
    }

    fun provideUpdateStudentUseCase() : UpdateStudentUseCase {
        return UpdateStudentUseCase(StudentRepositoryImpl())
    }

    fun provideDeleteStudentUseCase() : DeleteStudentUseCase {
        return DeleteStudentUseCase(StudentRepositoryImpl())
    }
}