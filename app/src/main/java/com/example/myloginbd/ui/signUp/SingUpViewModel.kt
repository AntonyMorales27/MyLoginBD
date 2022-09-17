package com.example.myloginbd.ui.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myloginbd.ui.Resource
import com.example.myloginbd.ui.dominio.dominio.model.User
import com.example.myloginbd.ui.dominio.dominio.usercase.FirebaseSinUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingUpViewModel @Inject constructor(
    private val signUpUseCase: FirebaseSinUpUseCase

) : ViewModel() {
    private val _signUpState: MutableLiveData<Resource<Boolean>> = MutableLiveData()
    val signUpState: LiveData<Resource<Boolean>>
    get() = _signUpState

    fun sinUp(user: User, password: String){
        viewModelScope.launch {
            signUpUseCase(user, password).onEach { state ->
                _signUpState.value = state

            }.launchIn(viewModelScope)
        }
    }
}