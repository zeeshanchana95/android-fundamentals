package com.example.tutorials
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        var todoList = mutableListOf(
            Todo("Follow AndroidDevs", false),
            Todo("Learn About RecyclerView", true),
            Todo("Feed my cat", false),
            Todo("Prank my boos", false),
            Todo("Eat some curry", true),
            Todo("Ask my crush out", false),
            Todo("Take a shower", false)
        )

        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter

        rvTodos.layoutManager = LinearLayoutManager(this)


        val etTodo = findViewById<EditText>(R.id.etTodo)
        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)

            //now empty etTodo
            etTodo.text.clear()

        }
    }

}