package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.app.DatePickerDialog
import java.util.Calendar

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
        val username = findViewById<EditText>(R.id.edit_user)
        val birthday = findViewById<EditText>(R.id.edit_birthdate)
        val uemail = findViewById<EditText>(R.id.edit_email)
        val password = findViewById<EditText>(R.id.edit_pass)
        val conf_pass = findViewById<EditText>(R.id.confirm_pass)
        val signbtn = findViewById<Button>(R.id.signbtn)

        val calendar = Calendar.getInstance()

        birthday.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val birthdate = "${selectedMonth + 1}-$selectedDay-$selectedYear"
                    birthday.setText(birthdate)
            }, year, month, day)

            datePickerDialog.show()
        }

        signbtn.setOnClickListener{
            val name = fullname.text.toString().trim()
            val user = username.text.toString().trim()
            val bday = birthday.text.toString().trim()
            val email = uemail.text.toString().trim()
            val pass = password.text.toString()
            val c_pass = conf_pass.text.toString()

            if (name.isEmpty() || user.isEmpty() || bday.isEmpty() || email.isEmpty() || pass.isEmpty() || c_pass.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            } else if (pass != c_pass) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_LONG).show()
                Toast.makeText(
                    this,
                    "Full Name: $name\nUsername: $user\nBirthdate: $bday\nEmail: $email\nPassword: $pass",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}