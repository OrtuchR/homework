package com.gmail.ortuchr.homework.hw_07

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.gmail.ortuchr.homework.R

class EditUserActivity : Fragment() {

    companion object {
        private const val USER_ID = "USER_ID"
        fun getFragment(long: Long): EditUserActivity {
            val fragment = EditUserActivity()
            val bundle = Bundle()
            bundle.putLong(USER_ID, long)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var userNewUrl: EditText
    private lateinit var userNewName: EditText
    private lateinit var userNewSurname: EditText
    private lateinit var userApplyChangesButton: Button
    private lateinit var linearLayoutEditUser: LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_edit_user, container, false)
        userNewUrl = view.findViewById(R.id.userNewUrl)
        userNewName = view.findViewById(R.id.userNewName)
        userNewSurname = view.findViewById(R.id.userNewSurname)
        userApplyChangesButton = view.findViewById(R.id.buttonApplyChanges)
        linearLayoutEditUser = view.findViewById(R.id.linearLayoutEditUser)

        return view
    }

    override fun onStart() {
        super.onStart()

        val userId = arguments!!.getLong(USER_ID)
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

                linearLayoutEditUser.removeView(userNewUrl)
                linearLayoutEditUser.removeView(userNewName)
                linearLayoutEditUser.removeView(userNewSurname)

                if (isOrientationPortrait()) {
                    fragmentManager?.popBackStack()
                } else {
                    val fragmentTransaction = fragmentManager!!.beginTransaction()
                    fragmentTransaction.remove(this)
                    fragmentTransaction.replace(R.id.fragmentUserList, UserListActivity.getFragment())
                    fragmentTransaction.replace(R.id.fragmentUserEdit, ViewUserActivity.getFragment(userId))
                    fragmentTransaction.commit()
                }
            }
        }
    }

    private fun isOrientationPortrait(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }
}