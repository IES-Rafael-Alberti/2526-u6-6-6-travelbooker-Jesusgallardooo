package org.practicatrim2.Dominio

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

abstract class Reserva(val descripcion: String) {

    val id: Int = generarId()

    val fechaCreacion: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()

    open val detalle: String
        get() = "$id - $descripcion"

    companion object {
        private var contador = 0

        fun generarId(): Int {
            contador++
            return contador
        }
    }
}