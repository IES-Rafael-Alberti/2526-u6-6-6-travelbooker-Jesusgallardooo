package org.practicatrim2.datos

import org.practicatrim2.Dominio.Reserva

class ReservaRepositorioMemoria: IReservaRepositorio{

    private val reservas = mutableListOf<Reserva>()

    override fun agregar(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun obtenerTodas(): List<Reserva> {
        return reservas.toList()
    }

}