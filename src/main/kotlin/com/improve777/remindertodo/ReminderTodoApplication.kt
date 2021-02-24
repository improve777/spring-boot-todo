package com.improve777.remindertodo

import com.improve777.remindertodo.service.TodoService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReminderTodoApplication

fun main(args: Array<String>) {
    val context = runApplication<ReminderTodoApplication>(*args)

    val todoService = context.getBean(TodoService::class.java)
    todoService.findTodoInfo()
}
