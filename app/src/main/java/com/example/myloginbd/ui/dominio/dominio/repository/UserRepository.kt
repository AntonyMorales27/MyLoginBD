package com.example.myloginbd.ui.dominio.dominio.repository

import com.example.myloginbd.ui.dominio.dominio.model.User

interface UserRepository {

    suspend fun createUser(user: User): Boolean

    suspend fun getUser(uid: String): User

}