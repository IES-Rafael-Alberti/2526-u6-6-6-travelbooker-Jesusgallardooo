package Presentacion

import org.practicatrim2.Servicios.ServicioReserva

class ConsolaUI(private val servicio: ServicioReserva) {

    fun mostrarMenu() {
        println()
        println("<<< TRAVELBOOKER >>>")
        println("1. Crear reserva.")
        println("2. Listar reservas.")
        println("3. Cancelar reserva.")
        println("4. Consultar reserva.")
        println("0. Salir.")
    }

    fun crearReservaVuelo() {

        println("Descripción:")
        val descripcion = readln()

        println("Origen:")
        val origen = readln()

        println("Destino:")
        val destino = readln()

        println("Hora (HH:MM):")
        val hora = readln()

        try {
            servicio.crearReservaVuelo(
                descripcion,
                origen,
                destino,
                hora
            )
            println("Reserva creada correctamente")

        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    fun crearReservaHotel() {

        println("Descripción:")
        val descripcion = readln()

        println("Ubicación:")
        val ubicacion = readln()

        println("Número de noches:")
        val noches = readln().toInt()

        servicio.crearReservaHotel(
            descripcion,
            ubicacion,
            noches
        )
        println("Reserva creada correctamente")
    }

    fun crearReserva(){

        println("Tipo de reserva:")
        println("1. Vuelo")
        println("2. Hotel")

        when(readln()){
            "1" -> crearReservaVuelo()
            "2" -> crearReservaHotel()
            else -> println("Tipo de reserva no válido.")
        }

    }

    fun listarReservas() {

        val reservas = servicio.obtenerTodasLasReservas()

        if (reservas.isEmpty()) {
            println("No hay reservas")
            return
        }

        reservas.forEach {
            println(it.detalle)
        }
    }

    fun cancelarReserva() {

        println("Introduce el ID de la reserva: ")
        val id = readln().toIntOrNull()

        if (id == null) {
            println("ID inválido: Debe ser un numero y pertenecer a alguna reserva.")
            return
        }

        servicio.cancelarReserva(id)

        println("Reserva cancelada.")
    }

    fun consultarReserva(){

        println("Introduce el ID de la reserva que quieras consultar:")

        val id = readln().toIntOrNull()

        if (id == null) {
            println("ID inválido...")
            return
        }

        val reserva = servicio.obtenerReservaPorId(id)

        if (reserva == null) {
            println("No existe una reserva con ese ID.")
        } else {
            println(reserva)
        }
    }

    fun iniciar(){

        var salir = false

        while (!salir) {
            mostrarMenu()

            when (readln()) {
                "1" -> crearReserva()
                "2" -> listarReservas()
                "3" -> cancelarReserva()
                "4" -> consultarReserva()
                "0" -> salir = true
                else -> println("Opción no válida")
            }
        }

    }
}