package org.practicatrim2.datos

import org.practicatrim2.Dominio.Reserva

interface IReservaRepositorio {
    fun agregar(reserva: Reserva)
    fun obtenerTodas(): List<Reserva>
}