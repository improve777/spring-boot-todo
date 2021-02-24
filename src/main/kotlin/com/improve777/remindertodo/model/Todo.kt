package com.improve777.remindertodo.model

import java.time.LocalDateTime

data class Todo(
    val id: Long,
    val title: String,
    val created: LocalDateTime = LocalDateTime.now(),
    val updated: LocalDateTime = LocalDateTime.now(),
    val deleted: LocalDateTime? = null,
    val isComplete: Boolean = false,
)
