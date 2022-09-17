package com.example.myloginbd.ui.password_recovery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myloginbd.databinding.ActivityMenu2Binding
import com.example.myloginbd.databinding.ActivityRecuperarContrasenaBinding
import com.example.myloginbd.ui.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecuperarContrasenaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarContrasenaBinding

    private val viewModel: PasswordRecoveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecuperarContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.passwordSent.observe(this) { state ->
            when(state) {
                is Resource.Success -> {
                    finish()
                    Toast.makeText(
                        this,
                        "Hemos enviado un link para reestablecer tu contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        state.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Loading -> {  }
                else -> Unit
            }
        }
    }


    private fun initListeners() {
        binding.button4.setOnClickListener {
            handlePasswordRecovery()
        }
    }

    private fun handlePasswordRecovery() {
        val email = binding.editTextTextEmailAddress2.text.toString()

        viewModel.sendPasswordLink(email)
    }
}