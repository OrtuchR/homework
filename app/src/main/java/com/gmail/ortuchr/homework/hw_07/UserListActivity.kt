package com.gmail.ortuchr.homework.hw_07

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gmail.ortuchr.homework.R

class UserListActivity : Fragment() {

    companion object {
        fun getFragment(): UserListActivity {
            return UserListActivity()
        }
    }

    private val dataSet = SingletonUserData.getUserData()
    private var newDataSet = mutableListOf<User>()
    private lateinit var recyclerViewUsersList: RecyclerView
    private lateinit var editTextSearchUser: EditText
    private lateinit var buttonAddNewUser: Button

    private val viewUsersAdapter = AdapterUserList {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        if (isOrientationPortrait()) {
            fragmentTransaction.replace(R.id.fragmentUserList, ViewUserActivity.getFragment(it.id))
            fragmentTransaction.addToBackStack(null)
        }
        else {
            fragmentTransaction.replace(R.id.fragmentUserEdit, ViewUserActivity.getFragment(it.id))
        }
        fragmentTransaction.commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_user_list, container, false)
        recyclerViewUsersList = view.findViewById(R.id.recyclerViewUsersList)
        editTextSearchUser = view.findViewById(R.id.editTextSearchUser)
        buttonAddNewUser = view.findViewById(R.id.buttonAddUser)
        recyclerViewUsersList.adapter = viewUsersAdapter
        recyclerViewUsersList.layoutManager = LinearLayoutManager(view.context)
        recyclerViewUsersList.setHasFixedSize(true)
        return view
    }

    override fun onStart() {
        super.onStart()

        if (editTextSearchUser.text.toString().isEmpty()) {
            viewUsersAdapter.userListDataSet = dataSet
        } else {
            getUserData(editTextSearchUser.text.toString())
        }

        buttonAddNewUser.setOnClickListener {
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            if (isOrientationPortrait()) {
                fragmentTransaction.replace(R.id.fragmentUserList, EditUserActivity.getFragment(0L))
                fragmentTransaction.addToBackStack(null)
            }
            else {
                fragmentTransaction.replace(R.id.fragmentUserEdit, EditUserActivity.getFragment(0L))
            }
            fragmentTransaction.commit()
        }

        editTextSearchUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                getUserData(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun getUserData(s: String) {
        var index = 0;
        newDataSet.removeAll(newDataSet)
        if (!s.isEmpty()) {
            s.trim()
            for (user: User in dataSet) {
                if (s.length <= user.name.length) {
                    if (user.name.substring(0, s.length).equals(s.toString(), true)) {
                        newDataSet.add(index, user)
                        index++
                        continue
                    }
                }
                if (s.length <= user.surname.length) {
                    if (user.surname.substring(0, s.length).equals(s.toString(), true)) {
                        newDataSet.add(index, user)
                        index++
                        continue
                    }
                }
            }
            if (index == 0) {
                newDataSet.removeAll(newDataSet)
                Toast.makeText(activity!!.applicationContext, R.string.errorEmptyList, Toast.LENGTH_SHORT).show()
            }
            viewUsersAdapter.userListDataSet = newDataSet
        } else {
            viewUsersAdapter.userListDataSet = dataSet
        }
    }

    private fun isOrientationPortrait(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }
}