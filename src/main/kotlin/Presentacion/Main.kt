package org.practicatrim2.Presentacion

import org.practicatrim2.Servicios.ServicioReserva
import org.practicatrim2.datos.ReservaRepositorioMemoria



fun main() {
    val repositorio = ReservaRepositorioMemoria()
    val service = ServicioReserva(repositorio)

    service.crearReservaVuelo("Vuelo a Roma", "Madrid", "Roma", "18:3   0")
    service.crearReservaHotel("Hotel céntrico en Roma", "Roma", 3)
    service.crearReservaVuelo("Vuelo a París", "Barcelona", "París", "09:45")

    val todas = service.obtenerTodasLasReservas()
    println("=== Todas las reservas ===")
    todas.forEach { println(it.detalle) }
}