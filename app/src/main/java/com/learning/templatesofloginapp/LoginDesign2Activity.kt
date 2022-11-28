package com.learning.templatesofloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.learning.templatesofloginapp.databinding.ActivityLoginDesign1Binding
import com.learning.templatesofloginapp.databinding.ActivityLoginDesign2Binding

class LoginDesign2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginDesign2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDesign2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

    }

    private fun initView() {
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)

        fun validateLogin(email: String, password: String): Boolean {
            return email.isNotEmpty() && password.isNotEmpty()
        }

        btnLogin.setOnClickListener {
            val email = etEmail?.text.toString()
            val password = etPassword?.text.toString()

            if (validateLogin(email, password)) {
                Toast.makeText(baseContext, "Logged in Successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(baseContext, "Enter email and password", Toast.LENGTH_LONG).show()
            }
        }
    }
}
