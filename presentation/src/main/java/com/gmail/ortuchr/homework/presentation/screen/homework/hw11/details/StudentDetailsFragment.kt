package com.gmail.ortuchr.homework.presentation.screen.homework.hw11.details

import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.view.View
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.app.App
import com.gmail.ortuchr.homework.databinding.FragmentStudentDetailsBinding
import com.gmail.ortuchr.homework.presentation.base.BaseMvvmFragment
import com.gmail.ortuchr.homework.presentation.screen.homework.hw11.StudentRouter
import com.jakewharton.rxbinding2.view.enabled

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

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        //intentFilter.addAction("android.net.wifi.STATE_CHANGE")
        App.instance.applicationContext.registerReceiver(myReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        App.instance.applicationContext.unregisterReceiver(myReceiver)
    }

    private val myReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val net: NetworkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO)
            if (net.isConnected) {
                binding.buttonAddStudent.isClickable = true
                binding.buttonDeleteStudent.isClickable = true
                binding.buttonUpdateStudent.isClickable = true
            } else {
                binding.buttonAddStudent.isClickable = false
                binding.buttonDeleteStudent.isClickable = false
                binding.buttonUpdateStudent.isClickable = false
            }
        }

    }
}