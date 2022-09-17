package com.example.myloginbd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BotonRegistrar = findViewById<Button>(R.id.Registar)
        BotonRegistrar.setOnClickListener {
            val Intent =  Intent(this,RegistroActivity::class.java)
            startActivity(Intent)
        }
        val BotonOlvideContraseña = findViewById<Button>(R.id.button3)
        BotonOlvideContraseña.setOnClickListener {
            val Intent =  Intent(this,RecuperarContrasenaActivity::class.java)
            startActivity(Intent)
        }
        val Botoninicio = findViewById<Button>(R.id.button2)
        Botoninicio.setOnClickListener {
            val Intent =  Intent(this,Menu2Activity::class.java)
            startActivity(Intent)
        }
        // SETUP

    }



}