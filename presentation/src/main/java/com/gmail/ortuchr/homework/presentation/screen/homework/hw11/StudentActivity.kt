package com.gmail.ortuchr.homework.presentation.screen.homework.hw11

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.databinding.ActivityStudentBinding
import com.gmail.ortuchr.homework.presentation.base.BaseMvvmActivity
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.list.StudentListFragment

class StudentActivity : BaseMvvmActivity<
        StudentViewModel,
        StudentRouter,
        ActivityStudentBinding>() {

    override fun provideViewModel(): StudentViewModel {
        return ViewModelProviders.of(this)
                .get(StudentViewModel::class.java)
    }

    override fun provideRouter(): StudentRouter {
        return StudentRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            router.goToStudentList()
        }
    }
}