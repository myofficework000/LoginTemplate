package com.learning.templatesofloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoginDesign3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_design3)
        initView()
    }

    private fun initView() {
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            Toast.makeText(baseContext, "Successfully logged in", Toast.LENGTH_SHORT).show()
        }
    }
}