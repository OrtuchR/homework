package com.gmail.ortuchr.homework.presentation.screen.homework.hw11.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.databinding.FragmentStudentListBinding
import com.gmail.ortuchr.homework.presentation.base.BaseMvvmFragment
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.StudentRouter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class StudentListFragment : BaseMvvmFragment<
        StudentListViewModel,
        StudentRouter,
        FragmentStudentListBinding>() {

    companion object {
        fun getInstance(): StudentListFragment {
            return StudentListFragment()
        }
    }

    override fun provideViewModel(): StudentListViewModel {
        return ViewModelProviders.of(this).get(StudentListViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_student_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //настройка recycleView

        binding.listRecyclerView.adapter = viewModel.adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.listRecyclerView.setHasFixedSize(true)

        RxTextView.textChanges(binding.searchEditText)
                //.throttleFirst(1, TimeUnit.SECONDS)
                .subscribeBy {
                    viewModel.search(it.toString())
                }
    }
}