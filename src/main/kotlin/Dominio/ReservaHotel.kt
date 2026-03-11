package org.practicatrim2.Dominio

import jdk.internal.loader.Resource

class ReservaHotel private constructor(
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int,
): Reserva(descripcion){

    override val detalle: String
        get() = "$id - $descripcion - $ubicacion ($numeroNoches noches)"

    override fun toString(): String {
        return """
            Reserva de Hotel
            ID: $id
            Fecha: $fechaCreacion
            Descripción: $descripcion
            ubicación: $ubicacion
            numero de noches: $numeroNoches
        """.trimIndent()
    }

    companion object {

        fun crearInstancia(
            descripcion: String,
            ubicacion: String,
            numeroNoches: Int,
        ): ReservaHotel {
            return ReservaHotel(descripcion, ubicacion, numeroNoches)
        }

    }

}