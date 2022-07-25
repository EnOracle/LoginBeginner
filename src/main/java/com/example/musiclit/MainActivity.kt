package com.example.musiclit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login_btn: Button = findViewById(R.id.enter_btn)
        login_btn.setOnClickListener {
            val intent = Intent(this, EnterPage::class.java)
            startActivity(intent)
        }
    }
}