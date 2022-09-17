package com.example.myloginbd.ui.remote

import com.example.myloginbd.ui.dominio.dominio.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth:FirebaseAuth
): AuthRepository {

    override suspend fun login(email: String, password: String): Boolean {

        return try {
            var isSuccessful: Boolean = false
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener { isSuccessful = false }
                .await()
            isSuccessful
        } catch (e: Exception){
            false
        }
    }

    override suspend fun SingUp(email: String, password: String): Boolean {
        return try {
            var isSuccessful: Boolean = false
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { isSuccessful = it.isSuccessful}
                .await()
            isSuccessful
        } catch (e: Exception){
            false
        }
    }
}