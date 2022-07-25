package com.example.musiclit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        var reset: Button = findViewById(R.id.forget_btn)
        reset.setOnClickListener {
            val etEmail: TextView = findViewById(R.id.signEmailAddress)
            val email: String = etEmail.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email must be fill!"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Email not valid"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, SignActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        baseContext, "Success",
                        Toast.LENGTH_SHORT
                    ).show()
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}



