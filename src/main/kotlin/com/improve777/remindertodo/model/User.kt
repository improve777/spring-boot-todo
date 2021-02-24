package com.improve777.remindertodo.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    val id: Long = 0,
    val email: String,
    val password: String,
    @OneToMany(mappedBy = "user")
    val todos: MutableList<Todo> = mutableListOf(),
) : Serializable {
    constructor() : this(0, "", "")

    fun registerTodo(todo: Todo) {
        todos.add(todo)
    }
}
