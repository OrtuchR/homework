package com.gmail.ortuchr.homework.presentation.screen.homework.hw10

import android.arch.lifecycle.ViewModelProviders
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.databinding.ActivityPersonInfoBinding
import com.gmail.ortuchr.homework.presentation.base.BaseMvvmActivity

class PersonInfoActivity : BaseMvvmActivity<
        PersonInfoViewModel,
        PersonInfoRouter,
        ActivityPersonInfoBinding>() {
    override fun provideViewModel(): PersonInfoViewModel {
        return ViewModelProviders.of(this)
                .get(PersonInfoViewModel::class.java)
    }

    override fun provideRouter(): PersonInfoRouter {
        return PersonInfoRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_person_info
}