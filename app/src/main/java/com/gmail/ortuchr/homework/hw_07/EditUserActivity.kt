package com.gmail.ortuchr.homework.hw_07

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gmail.ortuchr.homework.R
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

class EditUserActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
    }

    override fun onStart() {
        super.onStart()

        val userNewUrl = findViewById<EditText>(R.id.userNewUrl)
        val userNewName = findViewById<EditText>(R.id.userNewName)
        val userNewSurname = findViewById<EditText>(R.id.userNewSurname)
        val userApplyChangesButton = findViewById<Button>(R.id.buttonApplyChanges)

        val userId = intent.getLongExtra("USER_ID", 0)
        if (userId == 0L) {
            userNewUrl.hint = getString(R.string.userNewUrlHint)
            userNewName.hint = getString(R.string.userNewNameHint)
            userNewSurname.hint = getString(R.string.userNewSurnameHint)
            userApplyChangesButton.text = getString(R.string.userAddNewUser)
        } else {
            val dataSet = SingletonUserData.getUserData()
            for (user: User in dataSet) {
                if (user.id == userId) {
                    userNewUrl.setText(user.url)
                    userNewName.setText(user.name)
                    userNewSurname.setText(user.surname)
                }
            }
            userApplyChangesButton.text = getString(R.string.userSaveChanges)
        }

        userApplyChangesButton.setOnClickListener {
            if (userNewUrl.text.isEmpty() || userNewName.text.isEmpty() || userNewSurname.text.isEmpty()) {
                Toast.makeText(userNewName.context, R.string.errorEmptyView, Toast.LENGTH_SHORT).show()
            } else {
                if (userId == 0L) {
                    SingletonUserData.addUser(System.currentTimeMillis(), userNewName.text.toString(),
                            userNewSurname.text.toString(), userNewUrl.text.toString())
                } else {
                    SingletonUserData.updateUser(userId, userNewName.text.toString(),
                            userNewSurname.text.toString(), userNewUrl.text.toString())
                }
                finish()
            }
        }
    }
}