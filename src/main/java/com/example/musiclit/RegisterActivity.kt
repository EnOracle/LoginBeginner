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

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        val loginText: TextView = findViewById(R.id.sign_in_Register)
        loginText.setOnClickListener {
            val intent = Intent(this, FrontPage::class.java)
            startActivity(intent)
        }
//the register button

        val registerButton: Button = findViewById(R.id.register_btn_comp)
        registerButton.setOnClickListener {
            performSignUp()

        }

    }

    private fun performSignUp() {
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password_et)

        if (email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val intent = Intent(this, FrontPage::class.java)
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
                Toast.makeText(this, "Error occurred ${it.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
            }

    }

}
