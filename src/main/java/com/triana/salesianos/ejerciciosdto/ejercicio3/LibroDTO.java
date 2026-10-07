package com.triana.salesianos.ejerciciosdto.ejercicio3;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {

    public static LibroDTO fromEntity(Libro libro) {
        if (libro == null) {
            return null;
        }

        String nombreCompletoAutor = formatearNombreAutor(libro.getAutor());

        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreCompletoAutor,
                libro.getAnioPublicacion()
        );
    }

    private static String formatearNombreAutor(Autor autor) {
        if (autor == null) {
            return null;
        }
        String nombreCompleto = Stream.of(autor.getNombre(), autor.getApellido1(), autor.getApellido2())
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining(" "));

        return nombreCompleto.isBlank() ? null : nombreCompleto;
    }
}
