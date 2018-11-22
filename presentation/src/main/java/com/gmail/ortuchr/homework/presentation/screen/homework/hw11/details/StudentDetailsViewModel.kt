package com.gmail.ortuchr.homework.presentation.screen.homework.hw11.details

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.widget.Toast
import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.homework.app.App
import com.gmail.ortuchr.homework.factories.hw11.UseCaseProvider
import com.gmail.ortuchr.homework.presentation.base.BaseViewModel
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.StudentRouter
import io.reactivex.rxkotlin.subscribeBy

class StudentDetailsViewModel : BaseViewModel<StudentRouter>() {

    val isProgressEnabled = ObservableBoolean(false)
    val editTextStudentName = ObservableField<String>("")
    val editTextStudentAge = ObservableField<String>("")
    val editTextStudentUrl = ObservableField<String>("")
    val isStudentExist = ObservableBoolean(true)


    private lateinit var studentId: String
    private val simpleStudentUseCase = UseCaseProvider.provideGetSimpleStudentUseCase()
    private val addStudentUseCase = UseCaseProvider.provideAddStudentUseCase()
    private val updateStudentUseCase = UseCaseProvider.provideUpdateStudentUseCase()
    private val deleteStudentUseCase = UseCaseProvider.provideDeleteStudentUseCase()

    fun setStudentId(id: String) {
        studentId = id
        if (!studentId.isEmpty()) {
            isStudentExist.set(true)
            addToDisposable(
                    simpleStudentUseCase.get(studentId)
                            .subscribeBy(
                                    onNext = {
                                        isProgressEnabled.set(false)
                                        editTextStudentName.set(it.name)
                                        editTextStudentAge.set(it.age.toString())
                                        editTextStudentUrl.set(it.url)
                                    },
                                    onError = {
                                        isProgressEnabled.set(false)
                                        router?.showError(it)
                                    }
                            )
            )
        } else {
            isStudentExist.set(false)
        }
    }

    fun deleteStudent() {
        val deleteStudent = StudentDelete(studentId)
        addToDisposable(
                deleteStudentUseCase.delete(deleteStudent)
                        .subscribeBy(
                                onComplete = {
                                    if (router!!.checkPortrait()) {
                                        router?.goBack()
                                    } else {
                                        router?.removeFragment()
                                        router?.goToStudentList()
                                    }
                                },
                                onError = {
                                    isProgressEnabled.set(false)
                                    router?.showError(it)
                                }
                        )
        )
    }

    fun updateStudent() {
        val name = editTextStudentName.get()!!
        val age = editTextStudentAge.get()!!
        val url = editTextStudentUrl.get()!!
        if (name.isEmpty() || age.isEmpty() || url.isEmpty()) {
            Toast.makeText(App.instance.applicationContext, "Fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            val updateStudent = Student(studentId, name, age.toInt(), url)
            addToDisposable(
                    updateStudentUseCase.update(updateStudent)
                            .subscribeBy(
                                    onComplete = {
                                        if (router!!.checkPortrait()) {
                                            router?.goBack()
                                        } else {
                                            router?.goToStudentList()
                                        }
                                    },
                                    onError = {
                                        isProgressEnabled.set(false)
                                        router?.showError(it)
                                    }
                            )
            )
        }
    }

    fun addStudent() {
        val name = editTextStudentName.get()!!
        val age = editTextStudentAge.get()!!
        val url = editTextStudentUrl.get()!!
        var id = ""
        if (name.isEmpty() || age.isEmpty() || url.isEmpty()) {
            Toast.makeText(App.instance.applicationContext, "Fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            val addStudent = StudentAdd(name, age.toInt(), url)
            addToDisposable(
                    addStudentUseCase.add(addStudent)
                            .subscribeBy(
                                    onNext = {
                                        id = it.id
                                    },
                                    onComplete = {
                                        if (router!!.checkPortrait()) {
                                            router?.goBack()
                                        } else {
                                            router?.goToStudentDetails(id)
                                            router?.goToStudentList()
                                        }
                                    },
                                    onError = {
                                        isProgressEnabled.set(false)
                                        router?.showError(it)
                                    }
                            )
            )
        }
    }
}