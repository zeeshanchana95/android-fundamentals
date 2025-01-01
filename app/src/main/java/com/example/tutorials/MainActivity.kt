package com.example.tutorials

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_main.*

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
//        val btnApply = findViewById<Button>(R.id.btnApply)

        btnApply.setOnClickListener {
            val firstName = edtFirstName.text.toString()
            val lastName = edtLastName.text.toString()
            val birthDate = edtDateOfBirth.text.toString()
            val country = edtCountry.text.toString()
            Log.d("MainActivity", "$firstName $lastName born on $birthDate from $country just applied to formular.")

        }
    }
}