package com.gmail.ortuchr.homework.presentation.screen.homework.hw11

import android.support.v4.app.FragmentManager
import android.view.View
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.presentation.base.BaseRouter
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.details.StudentDetailsFragment
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.list.StudentListFragment

class StudentRouter(activity: StudentActivity)
    : BaseRouter<StudentActivity>(activity) {

    fun goToStudentList() {
        replaceFragment(
                activity.supportFragmentManager,
                StudentListFragment.getInstance(),
                R.id.container,
                false)
    }

    fun goToStudentDetails(id: String = "") {
        if (checkPortrait()) {
            replaceFragment(activity.supportFragmentManager,
                    StudentDetailsFragment.getInstance(id),
                    R.id.container,
                    true)
        } else {
            replaceFragment(activity.supportFragmentManager,
                    StudentDetailsFragment.getInstance(id),
                    R.id.containerDetails,
                    false)
        }
    }

    fun checkPortrait(): Boolean {
        val containerDetails = activity.findViewById<View>(R.id.containerDetails)
        return containerDetails == null
    }

    fun removeFragment() {
        if (checkPortrait()) {
            removeFragment(activity.supportFragmentManager, R.id.container)
        } else {
            removeFragment(activity.supportFragmentManager, R.id.containerDetails)
        }
    }
}