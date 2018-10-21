package com.gmail.ortuchr.homework.hw_07

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.ortuchr.homework.R

class ViewUserActivity : Fragment() {

    companion object {
        private const val USER_ID = "USER_ID"
        fun getFragment(long: Long): ViewUserActivity {
            val fragment = ViewUserActivity()
            val bundle = Bundle()
            bundle.putLong(USER_ID, long)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var imageViewUserPictureBig: ImageView
    private lateinit var userTextName: TextView
    private lateinit var userTextSurname: TextView
    private lateinit var userEditButton: Button
    private lateinit var userDeleteButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_view_user, container, false)

        imageViewUserPictureBig = view.findViewById(R.id.imageViewUserPictureBig)
        userTextName = view.findViewById(R.id.userNameText)
        userTextSurname = view.findViewById(R.id.userSurnameText)
        userEditButton = view.findViewById(R.id.buttonEditUser)
        userDeleteButton = view.findViewById(R.id.buttonDeleteUser)
        return view
    }

    override fun onStart() {
        super.onStart()

        val userId = arguments!!.getLong(USER_ID)
        val dataSet = SingletonUserData.getUserData()
        for (user: User in dataSet) {
            if (user.id == userId) {
                userTextName.text = user.name
                userTextSurname.text = user.surname
                Glide.with(activity!!.applicationContext).load(user.url)
                        .apply(RequestOptions.circleCropTransform()).into(imageViewUserPictureBig)
            }
        }

        userEditButton.setOnClickListener {
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            if (isOrientationPortrait()) {
                fragmentTransaction.replace(R.id.fragmentUserList, EditUserActivity.getFragment(userId))
                fragmentTransaction.addToBackStack(null)
            } else {
                fragmentTransaction.replace(R.id.fragmentUserEdit, EditUserActivity.getFragment(userId))
            }
            fragmentTransaction.commit()
        }

        userDeleteButton.setOnClickListener {
            SingletonUserData.deleteUser(userId)
            if (isOrientationPortrait()) {
                fragmentManager?.popBackStack()
            } else {
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.fragmentUserList, UserListActivity.getFragment())
                fragmentTransaction.remove(this)
                fragmentTransaction.commit()
            }
        }
    }

    private fun isOrientationPortrait(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }
}