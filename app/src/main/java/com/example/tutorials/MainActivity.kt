package com.example.tutorials

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

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

        val etName = findViewById<TextView>(R.id.etName)
        val etAge = findViewById<TextView>(R.id.etAge)
        val etCountry = findViewById<TextView>(R.id.etCountry)

        val btnApply = findViewById<Button>(R.id.btnApply)
        btnApply.setOnClickListener {

            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val country = etCountry.text.toString()

            Intent(this, SecondActivity2::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_AGE", age)
                it.putExtra("EXTRA_COUNTRY", country)
                startActivity(it)
            }
        }

    }
}