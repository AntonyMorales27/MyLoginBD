package com.example.myloginbd.ui.slideshow
import com.example.myloginbd.ui.dominio.dominio.repository.AuthRepository
import com.example.myloginbd.ui.dominio.dominio.repository.UserRepository
import com.example.myloginbd.ui.remote.FirebaseAuthRepositoryImpl
import com.example.myloginbd.ui.remote.FirebaseUserRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(authRepository: FirebaseAuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindUserRepository(authRepository: FirebaseUserRepositoryImpl): UserRepository
}