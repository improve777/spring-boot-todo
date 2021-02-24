package com.improve777.remindertodo

import com.improve777.remindertodo.model.Todo
import com.improve777.remindertodo.repository.TodoRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReminderTodoApplication

fun main(args: Array<String>) {
    val context = runApplication<ReminderTodoApplication>(*args)

    val todoRepository = context.getBean(TodoRepository::class.java)
    todoRepository.saveAll(
        listOf(
            Todo(title = "장보기"),
            Todo(title = "청소하기"),
            Todo(title = "계획세우기"),
            Todo(title = "글쓰기"),
        )
    )
    val todo = todoRepository.findByTitle("장보기")
    println(todo.toString())
}
