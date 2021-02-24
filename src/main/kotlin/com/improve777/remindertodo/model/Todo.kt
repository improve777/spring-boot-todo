package com.improve777.remindertodo.model

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import org.springframework.hateoas.RepresentationModel

@Entity
@Table(name = "TB_TODO")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TODO_ID")
    val id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    val user: User,
    val title: String,
    val created: LocalDateTime = LocalDateTime.now(),
    val updated: LocalDateTime = LocalDateTime.now(),
    val deleted: LocalDateTime? = null,
    val isComplete: Boolean = false,
) : RepresentationModel<Todo>(), Serializable {
    constructor() : this(0, User(), "", LocalDateTime.now(), LocalDateTime.now(), null, false)
}
