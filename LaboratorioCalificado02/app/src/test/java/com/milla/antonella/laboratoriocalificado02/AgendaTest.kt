package com.milla.antonella.laboratoriocalificado02

data class Contacto(
    val nombre: String,
    val telefono: String,
    val email: String
)

class Agenda {
    private val contactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
        println("Contacto agregado: $contacto")
    }

    fun listarContactos() {
        if (contactos.isEmpty()) {
            println("La agenda está vacía.")
        } else {
            println("Lista de contactos:")
            contactos.forEach { println(it) }
        }
    }

    fun buscarPorNombre(nombre: String) {
        val encontrados = contactos.filter { it.nombre.equals(nombre, ignoreCase = true) }
        if (encontrados.isEmpty()) {
            println("No se encontraron contactos con el nombre \"$nombre\".")
        } else {
            println("Contactos encontrados con el nombre \"$nombre\":")
            encontrados.forEach { println(it) }
        }
    }
}

fun main() {
    val agenda = Agenda()
    while (true) {
        println(
            """
            |Elige una opción:
            |1. Agregar contacto
            |2. Listar todos los contactos
            |3. Buscar contacto por nombre
            |4. Salir
            """.trimMargin()
        )

        print("Opción: ")
        val opcion = readLine()?.trim()

        when (opcion) {
            "1" -> {
                print("Nombre: ")
                val nombre = readLine()?.trim() ?: ""
                print("Teléfono: ")
                val telefono = readLine()?.trim() ?: ""
                print("Email: ")
                val email = readLine()?.trim() ?: ""

                if (nombre.isNotEmpty() && telefono.isNotEmpty() && email.isNotEmpty()) {
                    agenda.agregarContacto(Contacto(nombre, telefono, email))
                } else {
                    println("Error: Todos los campos son obligatorios.")
                }
            }
            "2" -> agenda.listarContactos()
            "3" -> {
                print("Ingresa el nombre a buscar: ")
                val nombreBuscado = readLine()?.trim() ?: ""
                agenda.buscarPorNombre(nombreBuscado)
            }
            "4" -> {
                println("Saliendo...")
                break
            }
            else -> println("Opción no válida, intenta de nuevo.")
        }

        println() // Línea en blanco para mejor lectura
    }
}
