package org.practicatrim2.Dominio

class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String,
) : Reserva(descripcion) {

    override val detalle: String
        get() = "$id - $descripcion - $origen -> $destino - $horaVuelo"

    override fun toString(): String {
        return """
            Reserva de Vuelo
            ID: $id
            Fecha: $fechaCreacion
            Descripción: $descripcion
            Ruta: $origen -> $destino
            Hora: $horaVuelo
        """.trimIndent()
    }

    companion object {

        fun crearInstancia(
            descripcion: String,
            origen: String,
            destino: String,
            horaVuelo: String,
        ): ReservaVuelo{

            val regexHora = Regex("^([0-1]?\\d|2[0-3]):([0-5]\\d)$")
            if (!regexHora.containsMatchIn(horaVuelo)){
                throw IllegalArgumentException("Hora de vuelo inválida")
            }

            return ReservaVuelo(descripcion, origen, destino, horaVuelo)

        }
    }
}