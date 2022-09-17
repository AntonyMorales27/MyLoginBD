package com.example.myloginbd.ui.remote

import android.util.Log
import com.example.myloginbd.ui.dominio.dominio.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth:FirebaseAuth
): AuthRepository {

    override suspend fun login(email: String, password: String): String {

        return try {
            var userUID = ""
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    userUID = it.user?.uid ?: ""
                }
                .await()
            userUID
        } catch (e: Exception){
            ""
        }
    }

    override suspend fun SingUp(email: String, password: String): String {
        return try {
            var userUID = ""
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    userUID = it.user?.uid ?: ""
                }
                .await()
            userUID
        } catch (e: Exception) {
            ""
        }
    }
}