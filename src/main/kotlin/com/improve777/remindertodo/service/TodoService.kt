package com.improve777.remindertodo.service

import com.improve777.remindertodo.model.Todo
import com.improve777.remindertodo.model.User
import com.improve777.remindertodo.repository.TodoRepository
import com.improve777.remindertodo.repository.UserRepository
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var todoRepository: TodoRepository

    @Transactional
    fun findTodoInfo() {
        val user = User(email = "test@gmail.com", password = "1234")
        userRepository.save(user)

        val todo1 = Todo(user = user, title = "일찍 자기")
        val todo2 = Todo(user = user, title = "산책하기")
        val todo3 = Todo(user = user, title = "독서하기")

        todoRepository.save(todo1)
        todoRepository.save(todo2)
        todoRepository.save(todo3)

        val list = todoRepository.findAll()
        for (todo in list) {
            println(todo)
        }
    }
}
