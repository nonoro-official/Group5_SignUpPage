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
        val uemail = findViewById<EditText>(R.id.edit_email)
        val password = findViewById<EditText>(R.id.edit_pass)
        val conf_pass = findViewById<EditText>(R.id.confirm_pass)
        val signbtn = findViewById<Button>(R.id.signbtn)

        signbtn.setOnClickListener{
            val email = uemail.text.toString()
            val pass = password.text.toString()
            val c_pass = conf_pass.text.toString()

            if(email.isEmpty() || pass.isEmpty() || c_pass.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            } else if (pass != c_pass) {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Email: $email\nPassword: $pass", Toast.LENGTH_LONG).show()
            }
        }

    }
}