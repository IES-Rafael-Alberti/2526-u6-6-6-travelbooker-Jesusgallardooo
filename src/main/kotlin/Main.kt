package org.practicatrim2

import org.practicatrim2.Dominio.ReservaHotel
import org.practicatrim2.Dominio.ReservaVuelo
import org.practicatrim2.datos.IReservaRepositorio
import org.practicatrim2.datos.ReservaRepositorioMemoria

fun main() {
    // Crear el repositorio en memoria
    val repositorio: IReservaRepositorio = ReservaRepositorioMemoria()

    // Crear algunas reservas
    val vuelo1 = ReservaVuelo.crearInstancia(
        descripcion = "Vuelo a Roma",
        origen = "Madrid",
        destino = "Roma",
        horaVuelo = "18:30"
    )

    val hotel1 = ReservaHotel.crearInstancia(
        descripcion = "Hotel céntrico en Roma",
        ubicacion = "Roma",
        numeroNoches = 3
    )

    val vuelo2 = ReservaVuelo.crearInstancia(
        descripcion = "Vuelo a París",
        origen = "Barcelona",
        destino = "París",
        horaVuelo = "09:45"
    )

    val hotel2 = ReservaHotel.crearInstancia(
        descripcion = "Hotel boutique en París",
        ubicacion = "París",
        numeroNoches = 2
    )

    // Agregar reservas al repositorio
    repositorio.agregar(vuelo1)
    repositorio.agregar(hotel1)
    repositorio.agregar(vuelo2)
    repositorio.agregar(hotel2)

    //Obtener todas las reservas y mostrarlas
    val todasLasReservas = repositorio.obtenerTodas()

    println("=== Reservas almacenadas en el repositorio ===")
    for (reserva in todasLasReservas) {
        println(reserva.detalle)
    }

    println("\n=== Información completa ===")
    for (reserva in todasLasReservas) {
        println(reserva)
        println("--------------------------")
    }
}