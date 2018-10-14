package com.gmail.ortuchr.homework.hw_07

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gmail.ortuchr.homework.R

class ViewUserActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);
    }

    override fun onStart() {
        super.onStart()

        val imageViewUserPictureBig = findViewById<ImageView>(R.id.imageViewUserPictureBig)
        val userTextName = findViewById<TextView>(R.id.userNameText)
        val userTextSurname = findViewById<TextView>(R.id.userSurnameText)
        val userEditButton = findViewById<Button>(R.id.buttonEditUser)
        val userDeleteButton = findViewById<Button>(R.id.buttonDeleteUser)

        val userId = intent.getLongExtra("USER_ID", 0)
        val dataSet = SingletonUserData.getUserData()
        for (user: User in dataSet) {
            if (user.id == userId) {
                userTextName.text = user.name
                userTextSurname.text = user.surname
                Glide.with(applicationContext).load(user.url)
                        .apply(RequestOptions.circleCropTransform()).into(imageViewUserPictureBig)
            }
        }

        userEditButton.setOnClickListener {
            val intent = Intent (applicationContext, EditUserActivity::class.java)
            intent.putExtra("USER_ID", userId)
            startActivity(intent)
        }

        userDeleteButton.setOnClickListener {
            SingletonUserData.deleteUser(userId)
            finish()
        }
    }

}