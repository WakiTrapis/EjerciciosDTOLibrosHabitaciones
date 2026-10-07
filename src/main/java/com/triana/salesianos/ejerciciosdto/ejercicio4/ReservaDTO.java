package com.triana.salesianos.ejerciciosdto.ejercicio4;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ReservaDTO(
    String codigo,
    String cliente,
    String habitacion,
    Integer numeroNoches,
    Double precioTotal
) {

    public static ReservaDTO fromEntity(Reserva reserva) {
        if (reserva == null) {
            return null;
        }

        String clienteFormateado = formatearCliente(reserva.getCliente());
        String habitacionFormateada = formatearHabitacion(reserva.getHabitacion());
        Double precioTotal = calcularPrecioTotal(reserva.getNumeroNoches(), reserva.getHabitacion());

        return new ReservaDTO(
            reserva.getCodigo(),
            clienteFormateado,
            habitacionFormateada,
            reserva.getNumeroNoches(),
            precioTotal
        );
    }

    private static String formatearCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        String nombreCompleto = Stream.of(cliente.getNombre(), cliente.getApellidos())
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining(" "));

        return nombreCompleto.isBlank() ? null : nombreCompleto;
    }

    private static String formatearHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            return null;
        }

        String numero = habitacion.getNumero() != null ? habitacion.getNumero().trim() : "";
        String tipo = habitacion.getTipo() != null ? habitacion.getTipo().trim() : "";

        if (!numero.isEmpty() && !tipo.isEmpty()) {
            return numero + " - " + tipo;
        } else if (!numero.isEmpty()) {
            return numero;
        } else if (!tipo.isEmpty()) {
            return tipo;
        }

        return null;
    }

    private static Double calcularPrecioTotal(Integer numeroNoches, Habitacion habitacion) {
        if (numeroNoches == null || habitacion == null || habitacion.getPrecioNoche() == null) {
            return null;
        }

        return numeroNoches * habitacion.getPrecioNoche();
    }
}
