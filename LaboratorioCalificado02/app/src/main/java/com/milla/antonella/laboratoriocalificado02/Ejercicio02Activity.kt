package com.milla.antonella.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.milla.antonella.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.etNombreCliente.text.toString().trim()
            val numero = binding.etNumeroCliente.text.toString().trim()
            val productos = binding.etProductos.text.toString().trim()
            val ciudad = binding.etCiudad.text.toString().trim()
            val direccion = binding.etDireccion.text.toString().trim()

            // Validar que todos los campos tengan datos
            if (nombre.isEmpty() || numero.isEmpty() || productos.isEmpty() || ciudad.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Enviar a PedidoDetalleActivity con los datos
            val intent = Intent(this, PedidoDetalleActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("numero", numero)
                putExtra("productos", productos)
                putExtra("ciudad", ciudad)
                putExtra("direccion", direccion)
            }
            startActivity(intent)
        }
    }
}
