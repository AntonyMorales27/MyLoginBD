package com.example.myloginbd.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myloginbd.Menu2Activity
import com.example.myloginbd.ui.password_recovery.RecuperarContrasenaActivity
import com.example.myloginbd.databinding.ActivityMainBinding
import com.example.myloginbd.ui.Resource
import com.example.myloginbd.ui.signUp.RegistroActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.loginState.observe(this) { state ->
            when(state) {
                is Resource.Success -> {
                    navigateToDashboard()
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

        binding.Registar.setOnClickListener {
            val Intent =  Intent(this, RegistroActivity::class.java)
            startActivity(Intent)
        }

        binding.button3.setOnClickListener {
            val Intent =  Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(Intent)
        }

        binding.button2.setOnClickListener {
            handleLogin()
        }

    }

    private fun handleLogin() {

        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        viewModel.login(email, password)
    }

    private fun navigateToDashboard() {
        val Intent =  Intent(this, Menu2Activity::class.java)
        startActivity(Intent)
    }
}