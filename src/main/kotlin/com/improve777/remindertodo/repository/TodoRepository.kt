package com.improve777.remindertodo.repository

import com.improve777.remindertodo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

    fun findByTitle(@Param("title") title: String): Todo
}
