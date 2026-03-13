package org.practicatrim2.Presentacion

import Presentacion.ConsolaUI
import org.practicatrim2.Servicios.ServicioReserva
import org.practicatrim2.datos.ReservaRepositorioMemoria



fun main() {

    val repositorio = ReservaRepositorioMemoria()
    val servicio = ServicioReserva(repositorio)
    val ui = ConsolaUI(servicio)

    ui.iniciar()
}