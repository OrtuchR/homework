package com.gmail.ortuchr.homework.hw_07

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gmail.ortuchr.homework.R

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentUserList, UserListActivity.getFragment())
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}