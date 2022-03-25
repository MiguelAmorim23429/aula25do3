package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teste.adapters.TodoAdapter
import com.example.teste.models.Todo
import kotlinx.android.synthetic.main.activity_main.*
import java.io.LineNumberReader
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

  private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      todoAdapter = TodoAdapter(ArrayList())

      rvTodoItems.adapter = todoAdapter
      rvTodoItems.layoutManager = LinearLayoutManager(this)

      btnAddTodo.setOnClickListener {
         val todoTitle = etTodo.text.toString()
          if (todoTitle.isNotEmpty()) {
            val todo = Todo(todoTitle, LocalDate.now())

            todoAdapter.addTodo(todo)

            etTodo.text.clear()
          }
      }
    }
}
