package com.example.musiclit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FrontPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)


        val forgetPassword: TextView = findViewById(R.id.text_forget)
        forgetPassword.setOnClickListener {
            Intent(this@FrontPage, ForgetPasswordActivity::class.java).also {
                startActivity(it)
            }

            val login_btn: Button = findViewById(R.id.login_btn)
            login_btn.setOnClickListener {
                val intent = Intent(this, SignActivity::class.java)
                startActivity(intent)
            }

            val register_btn: Button = findViewById(R.id.register_btn)
            register_btn.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

