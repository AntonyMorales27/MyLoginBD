package com.example.myloginbd.ui.dominio.dominio.model

import java.util.UUID

data class User(
    val uid: String = UUID.randomUUID().toString(),
    val email: String = "",
    val name: String = "",
    val lastName: String = "",
    val userName: String = "",
)
