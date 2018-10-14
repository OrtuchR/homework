package com.gmail.ortuchr.homework.hw_07

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gmail.ortuchr.homework.R

class UserListActivity : Activity() {

    val dataSet = SingletonUserData.getUserData()
    var newDataSet = mutableListOf<User>()

    private val viewUsersAdapter = AdapterUserList {
        val intent = Intent(applicationContext, ViewUserActivity::class.java)
        intent.putExtra("USER_ID", it.id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
    }

    override fun onStart() {
        super.onStart()

        val recyclerViewUsersList = findViewById<RecyclerView>(R.id.recyclerViewUsersList)
        val editTextSearchUser = findViewById<EditText>(R.id.editTextSearchUser)
        val buttonAddNewUser = findViewById<Button>(R.id.buttonAddUser)

        if (editTextSearchUser.text.toString().isEmpty()) {
            viewUsersAdapter.userListDataSet = dataSet
        } else {
            getUserData(editTextSearchUser.text.toString())
        }

        recyclerViewUsersList.adapter = viewUsersAdapter
        recyclerViewUsersList.layoutManager = LinearLayoutManager(this)
        recyclerViewUsersList.setHasFixedSize(true)

        buttonAddNewUser.setOnClickListener {
            val intent = Intent(applicationContext, EditUserActivity::class.java)
            startActivity(intent)
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
                Toast.makeText(applicationContext, R.string.errorEmptyList, Toast.LENGTH_SHORT).show()
            }
            viewUsersAdapter.userListDataSet = newDataSet
        } else {
            viewUsersAdapter.userListDataSet = dataSet
        }
    }

    override fun onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}