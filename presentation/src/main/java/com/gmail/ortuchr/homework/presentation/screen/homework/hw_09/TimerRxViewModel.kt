package com.gmail.ortuchr.homework.presentation.screen.homework.hw_09

import android.databinding.ObservableField
import com.gmail.ortuchr.homework.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class TimerRxViewModel() : BaseViewModel<TimerRxRouter>() {
    //private val isOnlyEven = ObservableField<Boolean>(false)
    init {
        val timerTextView = ObservableField<String>("0")
        /*isOnlyEven.set(false)
        val disposable = Observable
                .interval(1, TimeUnit.SECONDS)
                .filter {
                    it.rem(2) == 0L
                }
                .subscribeBy(
                        onNext = {
                            timerTextView.set(it.toString())
                        },
                        onError = {
                            timerTextView.set("Error: " + it.toString())
                        }
                )
        addToDisposable(disposable)*/

    }
}