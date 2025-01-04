package com.example.tutorials
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val spMonths = findViewById<Spinner>(R.id.spMonths)

        val customList = listOf("First", "Second", "Third", "Fourth")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spMonths.adapter = adapter

        spMonths.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,
                    "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }


}