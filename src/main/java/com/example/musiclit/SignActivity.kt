package com.example.musiclit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        auth = Firebase.auth

        val forgetPassword: TextView = findViewById(R.id.text_forget)
        forgetPassword.setOnClickListener {
            Intent(this@SignActivity, ForgetPasswordActivity::class.java).also {
                startActivity(it)
            }

        }

        val registerText: TextView = findViewById(R.id.register_btn)
        registerText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        val loginButton: Button = findViewById(R.id.login_btn)
        loginButton.setOnClickListener {
            performLogin()

        }
    }
    //get user input
    private fun performLogin() {
        val email: EditText = findViewById(R.id.signEmailAddress)
        val password: EditText = findViewById(R.id.signPassword)

        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Please fill all the field", Toast.LENGTH_SHORT ).show()
            return
        }

        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()

        auth.signInWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(baseContext, "Success",
                        Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }

            .addOnFailureListener{
                Toast.makeText(baseContext, "Authentication failed.${it.localizedMessage}",
                    Toast.LENGTH_SHORT).show()
            }
    }
}



