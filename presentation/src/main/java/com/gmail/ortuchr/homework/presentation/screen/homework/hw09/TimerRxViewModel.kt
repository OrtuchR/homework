package com.gmail.ortuchr.homework.presentation.screen.homework.hw09

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.gmail.ortuchr.homework.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class TimerRxViewModel() : BaseViewModel<TimerRxRouter>() {
    val isOnlyEven = ObservableBoolean(false)
    val timerTextView = ObservableField<String>("0")

    init {
        isOnlyEven.set(false)
        val disposable = Observable
                .interval(1, TimeUnit.SECONDS)
                .filter {
                    isOnlyEven.get() && it.rem(2) == 0L
                    || !isOnlyEven.get()
                }
                .subscribeBy(
                        onNext = {
                            timerTextView.set(it.toString())
                        },
                        onError = {
                            timerTextView.set("Error: " + it.toString())
                        }
                )
        addToDisposable(disposable)
    }
}
