package com.example.myloginbd.ui.dominio.dominio.usercase

import com.example.myloginbd.ui.Resource
import com.example.myloginbd.ui.dominio.dominio.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val loggedSuccessfully = authRepository.login(email, password)
        if (loggedSuccessfully){
            emit(Resource.Success(true))
        } else{
            emit(Resource.Error("Login Error"))
        }

    }
}
//authRepository.login(email, password)