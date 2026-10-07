package com.triana.salesianos.ejerciciosdto.ejercicio4;

public class MainDeMentira2 {
    public static void main(String[] args) {
        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nombre("Laura")
                .apellidos("Gómez Pérez")
                .email("laura@example.com")
                .telefono("600112233")
                .build();

        Habitacion habitacion1 = Habitacion.builder()
                .id(10L)
                .numero("204")
                .tipo("Doble")
                .precioNoche(85.50)
                .planta(2)
                .build();

        Reserva reservaCompleta = Reserva.builder()
                .id(100L)
                .codigo("RES-001")
                .numeroNoches(3)
                .cliente(cliente1)
                .habitacion(habitacion1)
                .build();

        Reserva reservaSinCliente = Reserva.builder()
                .id(101L)
                .codigo("RES-002")
                .numeroNoches(2)
                .cliente(null)
                .habitacion(habitacion1)
                .build();

        Reserva reservaSinHabitacion = Reserva.builder()
                .id(102L)
                .codigo("RES-003")
                .numeroNoches(4)
                .cliente(cliente1)
                .habitacion(null)
                .build();

        Reserva reservaSinNoches = Reserva.builder()
                .id(103L)
                .codigo("RES-004")
                .numeroNoches(null)
                .cliente(cliente1)
                .habitacion(habitacion1)
                .build();

        Habitacion habitacionSinPrecio = Habitacion.builder()
                .id(11L)
                .numero("101")
                .tipo("Individual")
                .precioNoche(null)
                .planta(1)
                .build();

        Reserva reservaSinPrecioNoche = Reserva.builder()
                .id(104L)
                .codigo("RES-005")
                .numeroNoches(5)
                .cliente(cliente1)
                .habitacion(habitacionSinPrecio)
                .build();

        System.out.println("1. Completa:           " + ReservaDTO.fromEntity(reservaCompleta));
        System.out.println("2. Sin cliente:        " + ReservaDTO.fromEntity(reservaSinCliente));
        System.out.println("3. Sin habitación:     " + ReservaDTO.fromEntity(reservaSinHabitacion));
        System.out.println("4. Sin número noches:  " + ReservaDTO.fromEntity(reservaSinNoches));
        System.out.println("5. Sin precio noche:   " + ReservaDTO.fromEntity(reservaSinPrecioNoche));
        System.out.println("6. Reserva null:       " + ReservaDTO.fromEntity(null));
    }
}
