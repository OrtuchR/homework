package com.gmail.ortuchr.homework.presentation.screen.homework.hw11.list

import android.databinding.ObservableBoolean
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
import com.gmail.ortuchr.homework.factories.hw11.UseCaseProvider
import com.gmail.ortuchr.homework.presentation.base.BaseViewModel
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.StudentRouter
import com.gmail.ortuchr.homework.presentation.utils.StudentListAdapter
import io.reactivex.rxkotlin.subscribeBy

class StudentListViewModel : BaseViewModel<StudentRouter>() {

    val adapter: StudentListAdapter = StudentListAdapter{
        router?.goToStudentDetails(it.id)
    }

    val isProgressEnabled = ObservableBoolean(false)

    private val studentListUseCase = UseCaseProvider.provideGetStudentListUseCase()
    private val searchStudentsUseCase = UseCaseProvider.provideSearchStudentUseCase()

    init {
        isProgressEnabled.set(true)
        val disposable = studentListUseCase.get()
                .subscribeBy(
                        onNext = {
                            isProgressEnabled.set(false)
                            adapter.setData(it)
                        },
                        onError = {
                            isProgressEnabled.set(false)
                            router?.showError(it)
                        }
                )
        addToDisposable(disposable)
    }

    fun search(search: String) {
        if (isProgressEnabled.get()) return
        if (search.isEmpty()) {
            val disposable = studentListUseCase.get()
                    .subscribeBy(
                            onNext = {
                                isProgressEnabled.set(false)
                                adapter.setData(it)
                            },
                            onError = {
                                isProgressEnabled.set(false)
                                router?.showError(it)
                            }
                    )
            addToDisposable(disposable)
        } else {
            val studentSearch = StudentSearch(search)
            val disposable = searchStudentsUseCase.search(studentSearch)
                    .subscribeBy(
                            onNext = {
                                adapter.setData(it)
                            },
                            onError = {
                                router?.showError(it)
                            }
                    )
            addToDisposable(disposable)
        }
    }

    fun addNewUser() {
        router?.goToStudentDetails()
    }
}