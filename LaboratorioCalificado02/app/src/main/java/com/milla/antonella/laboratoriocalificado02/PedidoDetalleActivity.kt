package com.milla.antonella.laboratoriocalificado02

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.milla.antonella.laboratoriocalificado02.databinding.ActivityPedidoDetalleBinding

class PedidoDetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos enviados
        val nombre = intent.getStringExtra("nombre") ?: ""
        val numero = intent.getStringExtra("numero") ?: ""
        val productos = intent.getStringExtra("productos") ?: ""
        val ciudad = intent.getStringExtra("ciudad") ?: ""
        val direccion = intent.getStringExtra("direccion") ?: ""

        // Mostrar datos en la UI (añade esto en tu layout)
        binding.tvNombreCliente.text = nombre
        binding.tvNumeroCliente.text = numero
        binding.tvProductos.text = productos
        binding.tvUbicacion.text = "$ciudad, $direccion"

        // Botón llamar
        binding.btnLlamar.setOnClickListener {
            Toast.makeText(this, "Llamando a $nombre ($numero)", Toast.LENGTH_SHORT).show()
        }

        // Botón WhatsApp
        binding.btnWsp.setOnClickListener {
            val mensaje = "Hola $nombre, tus productos: $productos están en camino a la dirección: $direccion"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }

        // Botón Maps
        binding.btnMaps.setOnClickListener {
            Toast.makeText(this, "Mostrando ubicación: $ciudad, $direccion", Toast.LENGTH_SHORT).show()
        }
    }
}
