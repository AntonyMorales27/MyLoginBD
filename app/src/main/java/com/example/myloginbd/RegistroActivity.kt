package com.example.myloginbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
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

    }

    private fun Setup(){

    }


  /* override fun OnCreate(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityRegistroBinding.inflate(inflater,container, false)
        return binding.root

    }*/

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        initObservers()
        initListener()
    }
    private fun initObservers() {
        viewModel.signUpState.observe(viewLifecycleOwner){ state ->
            when(state){
                is Resource.Success ->{
                    handleLoading(isLoading = false)
                }
            }

        }
        /*viewModel.signUpState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is Resource.Success -> {
                    handleLoading(isLoading = false)
                    activity?.onBackPressed()
                    Toast.makeText(
                        requireContext(),
                        "Sign up success",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Error -> {
                    handleLoading(isLoading = false)
                    Toast.makeText(
                        requireContext(),
                        state.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Loading -> handleLoading(isLoading = true)
                else -> Unit
            }
        }*/
    }
     private fun initListener(){
         with(binding){
            singUpButton.setOnClickListener {
               handleSignUp()
            }
         }
     }

    private fun handleSignUp(){
        val email = binding.toString()
        val password = binding.toString()

        viewModel.sinUp(email, password)
    }
}