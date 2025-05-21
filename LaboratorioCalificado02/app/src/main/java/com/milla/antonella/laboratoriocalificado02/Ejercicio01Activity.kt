package com.milla.antonella.laboratoriocalificado02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.milla.antonella.laboratoriocalificado02.databinding.ActivityEjercicio01Binding

class Ejercicio01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicialmente el área verde está oculta
        binding.viewAreaPrincipal.visibility = android.view.View.GONE

        // Botón mostrar: hace visible el área verde
        binding.btnMostrar.setOnClickListener {
            binding.viewAreaPrincipal.visibility = android.view.View.VISIBLE
        }

        // Botón ocultar: oculta el área verde
        binding.btnOcultar.setOnClickListener {
            binding.viewAreaPrincipal.visibility = android.view.View.GONE
        }
    }
}
