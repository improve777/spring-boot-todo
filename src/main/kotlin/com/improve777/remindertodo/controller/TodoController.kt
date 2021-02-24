package com.improve777.remindertodo.controller

import com.improve777.remindertodo.BaseResponse
import com.improve777.remindertodo.HOST
import com.improve777.remindertodo.model.Todo
import com.improve777.remindertodo.request.TodoRequest
import com.improve777.remindertodo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Link
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController {

    @Autowired
    private lateinit var todoService: TodoService

    @GetMapping("/todos/{id}")
    fun getTodosByUserId(
        @PathVariable("id") id: Long,
    ): ResponseEntity<BaseResponse<List<Todo>>> {
        val todos = todoService.findTodosByUserId(id)

        todos.forEach {
            it.add(Link.of("$HOST/todos/${it.id}"))
        }

        return ResponseEntity.ok(
            BaseResponse.ok(
                message = "success",
                data = todos
            )
        )
    }

    @PostMapping("/todos")
    fun postTodo(
        @RequestBody todoReq: TodoRequest,
    ): ResponseEntity<BaseResponse<String>> {
        val isSuccess = todoService.add(todoReq)

        return if (isSuccess) {
            ResponseEntity.ok(
                BaseResponse.ok(message = "success")
            )
        } else {
            ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(
                    BaseResponse.error(
                        code = HttpStatus.NO_CONTENT.value(),
                        message = "전체 할일이 없습니다",
                        error = "all todos is null"
                    )
                )
        }
    }
}
