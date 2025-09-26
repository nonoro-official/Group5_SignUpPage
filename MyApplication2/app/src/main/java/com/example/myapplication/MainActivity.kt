package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fullname = findViewById<EditText>(R.id.edit_fullname)
        val username = findViewById<EditText>(R.id.editTextText4)
        val uemail = findViewById<EditText>(R.id.edit_email)
        val password = findViewById<EditText>(R.id.edit_pass)
        val conf_pass = findViewById<EditText>(R.id.confirm_pass)
        val signbtn = findViewById<Button>(R.id.signbtn)

        signbtn.setOnClickListener{
            val name = fullname.text.toString().trim()
            val user = username.text.toString().trim()
            val email = uemail.text.toString().trim()
            val pass = password.text.toString()
            val c_pass = conf_pass.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Fullname is required", Toast.LENGTH_LONG).show()
            } else if (user.isEmpty()) {
                Toast.makeText(this, "Username is required", Toast.LENGTH_LONG).show()
            } else if (email.isEmpty() || pass.isEmpty() || c_pass.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            } else if (pass != c_pass) {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_LONG).show()
                Toast.makeText(
                    this,
                    "Full Name: $name\nUsername: $user\nEmail: $email\nPassword: $pass",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}