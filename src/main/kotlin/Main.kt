package org.practicatrim2

import org.practicatrim2.Dominio.ReservaHotel
import org.practicatrim2.Dominio.ReservaVuelo
import org.practicatrim2.Dominio.Reserva

fun main() {
    // Probando ReservaVuelo
    val vuelo1 = ReservaVuelo.crearInstancia(
        descripcion = "Vuelo a Roma",
        origen = "Madrid",
        destino = "Roma",
        horaVuelo = "18:30"
    )

    val vuelo2 = ReservaVuelo.crearInstancia(
        descripcion = "Vuelo a París",
        origen = "Barcelona",
        destino = "París",
        horaVuelo = "09:45"
    )

    // Probando ReservaHotel
    val hotel1 = ReservaHotel.crearInstancia(
        descripcion = "Hotel céntrico en Roma",
        ubicacion = "Roma",
        numeroNoches = 3
    )

    val hotel2 = ReservaHotel.crearInstancia(
        descripcion = "Hotel boutique en París",
        ubicacion = "París",
        numeroNoches = 2
    )

    // Guardarlas en una lista de Reserva para probar polimorfismo
    val reservas: List<Reserva> = listOf(vuelo1, hotel1, vuelo2, hotel2)

    println("=== Detalle de todas las reservas ===")
    for (reserva in reservas) {
        println(reserva.detalle)
    }

    println("\n=== Información completa de todas las reservas ===")
    for (reserva in reservas) {
        println(reserva)
        println("--------------------------")
    }
}