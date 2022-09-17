package com.example.myloginbd.ui.dominio.dominio.usercase

import com.example.myloginbd.ui.Resource
import com.example.myloginbd.ui.dominio.dominio.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseSinUpUseCase @Inject constructor(
    private val authRepository: AuthRepository

) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val isSignUpSuccessFully = authRepository.SingUp(email, password)
        if (isSignUpSuccessFully){
        emit(Resource.Success(true))
        } else {
             emit(Resource.Error("SignUp Error"))
    }
}
}