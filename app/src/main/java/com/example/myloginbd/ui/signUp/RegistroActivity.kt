package com.example.myloginbd.ui.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myloginbd.databinding.ActivityMainBinding.inflate
import com.example.myloginbd.databinding.ActivityMenu2Binding.inflate
import com.example.myloginbd.databinding.ActivityRegistroBinding
import com.example.myloginbd.ui.Resource
import com.example.myloginbd.ui.dominio.dominio.model.User
import com.example.myloginbd.ui.signUp.SingUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    private val viewModel: SingUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityRegistroBinding.inflate(layoutInflater)
       val view = binding.root
       setContentView(view)

        initObservers()
        initListener()
    }

    private fun initObservers() {
        viewModel.signUpState.observe(this){ state ->
            when(state){
                is Resource.Success -> {
                    finish()
                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(this, "Error: ${state.message}", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Otra caso
                }
            }
        }
    }
     private fun initListener(){
         with(binding){
            singUpButton.setOnClickListener {
               handleSignUp()
            }
         }
     }

    private fun handleSignUp(){

        val user = User(
            email = binding.editTextTextEmailAddress.text.toString(),
            name = binding.editTextTextPersonName.text.toString(),
            lastName = binding.editTextTextLasName.text.toString(),
            userName = binding.editTextTextUserName.text.toString(),
        )

        val password = binding.editTextTextPassword.text.toString()

        viewModel.sinUp(user, password)
    }
}