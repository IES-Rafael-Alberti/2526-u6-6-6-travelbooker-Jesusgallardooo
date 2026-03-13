package org.practicatrim2.Servicios

import org.practicatrim2.Dominio.ReservaVuelo
import org.practicatrim2.datos.IReservaRepositorio
import org.practicatrim2.Dominio.Reserva
import org.practicatrim2.Dominio.ReservaHotel

class ServicioReserva (private val repositorio: IReservaRepositorio) {

    fun crearReservaVuelo(
        descripcion: String,
        origen: String,
        destino: String,
        horaVuelo: String
    ): ReservaVuelo{
        val vuelo = ReservaVuelo.crearInstancia(descripcion, origen, destino, horaVuelo)
        repositorio.agregar(vuelo)
        return vuelo
    }

    fun crearReservaHotel(
        descripcion: String,
        ubicacion: String,
        numeroNoches: Int
    ): ReservaHotel{
        val hotel = ReservaHotel.crearInstancia(descripcion, ubicacion, numeroNoches)
        repositorio.agregar(hotel)
        return hotel

    }

    fun cancelarReserva(id: Int) {

        val reserva = repositorio.obtenerTodas().find { it.id == id }

        if (reserva == null) {
            throw IllegalArgumentException("No existe una reserva con id $id")
        }

        repositorio.eliminar(id)
    }

    fun obtenerReservaPorId(id: Int): Reserva? {
        return repositorio.obtenerTodas().find { it.id == id }
    }

    fun obtenerTodasLasReservas(): List<Reserva>{
        return repositorio.obtenerTodas()
    }

}