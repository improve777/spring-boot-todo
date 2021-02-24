package com.improve777.remindertodo

import com.improve777.remindertodo.service.TodoService
import com.improve777.remindertodo.service.UserService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReminderTodoApplication

fun main(args: Array<String>) {
    val context = runApplication<ReminderTodoApplication>(*args)

    val todoService = context.getBean(TodoService::class.java)
    todoService.findTodoInfo()

    val userService = context.getBean(UserService::class.java)
    userService.findUserInfo()
}
