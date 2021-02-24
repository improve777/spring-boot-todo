package com.improve777.remindertodo.service

import com.improve777.remindertodo.model.Todo
import com.improve777.remindertodo.model.User
import com.improve777.remindertodo.repository.UserRepository
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Transactional
    fun findUserInfo() {
        val user1 = User(email = "test@gmail.com", password = "1234")
        user1.registerTodo(Todo(title = "일찍 자기"))
        user1.registerTodo(Todo(title = "산책하기"))

        val user2 = User(email = "test2@naver.com", password = "1234")
        user2.registerTodo(Todo(title = "운동하기"))
        user2.registerTodo(Todo(title = "독서하기"))

        userRepository.save(user1)
        userRepository.save(user2)

        userRepository.findAll().forEach {
            println("userId = ${it.id}, email = ${it.email}, todos size = ${it.todos.size}")
        }
    }
}
