package com.improve777.remindertodo.controller

import com.improve777.remindertodo.BaseResponse
import com.improve777.remindertodo.HOST
import com.improve777.remindertodo.model.Todo
import com.improve777.remindertodo.request.TodoRequest
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

    val todos = mutableListOf(
        Todo(1, "장보기"),
        Todo(2, "청소하기"),
        Todo(3, "계획세우기"),
        Todo(4, "글쓰기"),
    )

    @GetMapping("/todos/{id}")
    fun getTodosByUserId(
        @PathVariable("id") id: Long,
    ): ResponseEntity<BaseResponse<List<Todo>>> {
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
        val todoId = todos.lastOrNull()?.id
            ?: return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(
                    BaseResponse.error(
                        code = HttpStatus.NO_CONTENT.value(),
                        message = "전체 할일이 없습니다",
                        error = "all todos is null"
                    )
                )

        val todo = Todo(todoId + 1, todoReq.title)
        todos.add(todo)

        return ResponseEntity.ok(
            BaseResponse.ok(message = "success")
        )
    }
}
