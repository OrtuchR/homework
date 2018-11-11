package com.gmail.ortuchr.homework.presentation.screen.homework.hw11.details

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
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
    private val searchStudentsUseCase = UseCaseProvider.provideSearchStudentUseCase()

    fun setStudentId(id: String) {
        studentId = id
        if (!studentId.isEmpty()) {
            isStudentExist.set(true)
            val disposable = simpleStudentUseCase.get(studentId)
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
            addToDisposable(disposable)
        } else {
            isStudentExist.set(false)
            editTextStudentName.set("Add name")
            editTextStudentAge.set("")
            editTextStudentUrl.set("Add url")
        }
    }

    fun deleteStudent() {
        val deleteStudent = StudentDelete(studentId)
        val disposable = deleteStudentUseCase.delete(deleteStudent)
                .subscribeBy(
                        onError = {
                            isProgressEnabled.set(false)
                            router?.showError(it)
                        }
                )
        addToDisposable(disposable)
        if (!router!!.checkPortrait()) router?.removeFragment()
        router?.goToStudentList()
    }

    fun updateStudent() {
        val name = editTextStudentName.get()!!
        val age = editTextStudentAge.get()!!
        val url = editTextStudentUrl.get()!!
        if (name.isEmpty() || age.isEmpty() || url.isEmpty()) {
            //makeText
        } else {
            val updateStudent = Student(studentId, name, age.toInt(), url)
            val disposable = updateStudentUseCase.update(updateStudent)
                    .subscribeBy(
                            onError = {
                                isProgressEnabled.set(false)
                                router?.showError(it)
                            }
                    )
            addToDisposable(disposable)
        }
        router?.goToStudentList()
    }

    fun addStudent() {
        val name = editTextStudentName.get()!!
        val age = editTextStudentAge.get()!!
        val url = editTextStudentUrl.get()!!
        if (name.isEmpty() || age.isEmpty() || url.isEmpty()) {
            //makeText
        } else {
            val addStudent = StudentAdd(name, age.toInt(), url)
            val disposable = addStudentUseCase.add(addStudent)
                    .subscribeBy(
                            onError = {
                                isProgressEnabled.set(false)
                                router?.showError(it)
                            }
                    )
            addToDisposable(disposable)
            router?.goToStudentList()
            if (!router!!.checkPortrait()) {
                val studentSearch = StudentSearch(name)
                val disposable2 = searchStudentsUseCase.search(studentSearch)
                        .subscribeBy(
                                onNext = {
                                    router?.goToStudentDetails(it[0].id)
                                },
                                onError = {
                                    router?.showError(it)
                                }
                        )
                addToDisposable(disposable2)
            }
        }
    }
}