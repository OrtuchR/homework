package com.gmail.ortuchr.homework.presentation.screen.homework.hw_09

import android.arch.lifecycle.ViewModelProviders
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.databinding.ActivityTimerRxBinding
import com.gmail.ortuchr.homework.presentation.base.BaseMvvmActivity

class TimerRxActivity : BaseMvvmActivity<
        TimerRxViewModel,
        TimerRxRouter,
        ActivityTimerRxBinding>() {

    override fun provideViewModel(): TimerRxViewModel {
        return ViewModelProviders.of(this)
                .get(TimerRxViewModel::class.java)
    }

    override fun provideRouter(): TimerRxRouter {
        return TimerRxRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_timer_rx
}