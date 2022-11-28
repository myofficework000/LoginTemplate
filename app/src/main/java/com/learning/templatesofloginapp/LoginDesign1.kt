package com.learning.templatesofloginapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.learning.templatesofloginapp.databinding.ActivityLoginDesign1Binding

class LoginActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityLoginDesign1Binding
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDesign1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() = with(binding) {

    }

    private fun setData(name:String, userID: String, email: String, pass: String ){
        editor.apply{
            putString(NAME,name)
            putString(USER_ID,userID)
            putString(EMAIL,email)
            putString(PASSWORD,pass)
            if (commit()) {
                Toast.makeText(baseContext,"Registered Successfully",Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun validateRegistration(
        name: String,
        ID: String,
        email: String,
        pass: String,
        confPass: String,
        check: Boolean
    ) :Int {
        var everythingTrue = 0
        var termsAndConditions = checkValidate(check)
        everythingTrue += nameValidate(name)
        everythingTrue += iDValidate(ID)
        everythingTrue += emailValidate(email)
        everythingTrue += passwordValidate(pass, confPass)
        everythingTrue += termsAndConditions

        if (everythingTrue == 5) {
            return 1
        } else if (termsAndConditions != 1) {
            return 2
        } else {
            return 3
        }
    }

    private fun doToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun checkValidate(check: Boolean): Int {
        return if (check) {
            1
        } else 0
    }

    private fun passwordValidate(pass: String, confPass: String): Int {
        return if (pass.length > 5 && (pass == confPass)) {
            1
        } else 0
    }

    private fun emailValidate(email: String): Int {
        return if (email.isNotEmpty()) {
            1
        } else 0
    }

    private fun iDValidate(id: String): Int {
        return if (id.isNotEmpty()) {
            1
        } else 0
    }

    private fun nameValidate(name: String): Int {
        return if (name.isNotEmpty()) {
            1
        } else 0
    }

    companion object {
        const val FILENAME = "registration-details"
        const val EMAIL = "email"
        const val NAME = "name"
        const val USER_ID = "userID"
        const val PASSWORD = "password"
        const val CHECKBOX = "checkbox"
    }
}