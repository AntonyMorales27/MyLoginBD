package com.example.myloginbd.ui.dominio.dominio.usercase

import com.example.myloginbd.ui.Resource
import com.example.myloginbd.ui.dominio.dominio.model.User
import com.example.myloginbd.ui.dominio.dominio.repository.AuthRepository
import com.example.myloginbd.ui.dominio.dominio.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseSinUpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val isSignUpSuccessFully = authRepository.SingUp(user.email, password)

        var isDBRegisteredSuccessfully = false

        if (isSignUpSuccessFully){
            isDBRegisteredSuccessfully = userRepository.createUser(user)
        }

        if (isDBRegisteredSuccessfully) {
            emit(Resource.Success(true))
        } else {
            emit(Resource.Error("Sign up error"))
        }
    }
}