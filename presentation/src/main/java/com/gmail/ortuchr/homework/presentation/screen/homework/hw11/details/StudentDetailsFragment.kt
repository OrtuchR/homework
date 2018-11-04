package com.gmail.ortuchr.homework.presentation.screen.homework.hw11.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.View
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.databinding.FragmentStudentDetailsBinding
import com.gmail.ortuchr.homework.presentation.base.BaseMvvmFragment
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.StudentRouter

class StudentDetailsFragment : BaseMvvmFragment<
        StudentDetailsViewModel,
        StudentRouter,
        FragmentStudentDetailsBinding>() {

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"

        fun getInstance(id: String) : StudentDetailsFragment {
            val fragment = StudentDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): StudentDetailsViewModel {
        return ViewModelProviders.of(this).
                get(StudentDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_student_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(ID_EXTRA)
        if (id != null) {
            viewModel.setStudentId(id)
        } else {
            router?.goBack()
        }
    }
}