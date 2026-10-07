package com.triana.salesianos.ejerciciosdto.ejercicio3;

public class MainDeMentira {
    public static void main(String[] args) {
        Autor autor1 = Autor.builder()
                .id(1L)
                .nombre("Gabriel")
                .apellido1("García")
                .apellido2("Márquez")
                .nacionalidad("Colombiana")
                .build();

        Autor autor2 = Autor.builder()
                .id(2L)
                .nombre("George")
                .apellido1("Orwell")
                .apellido2(null)
                .nacionalidad("Británica")
                .build();

        Libro libro1 = Libro.builder()
                .id(101L)
                .titulo("Cien años de soledad")
                .isbn("978-0307474728")
                .anioPublicacion(1967)
                .numeroPaginas(496)
                .autor(autor1)
                .build();

        Libro libro2 = Libro.builder()
                .id(102L)
                .titulo("1984")
                .isbn("978-0451524935")
                .anioPublicacion(1949)
                .numeroPaginas(328)
                .autor(autor2)
                .build();

        Libro libro3 = Libro.builder()
                .id(103L)
                .titulo("Manuscrito Anónimo")
                .isbn("978-0000000000")
                .anioPublicacion(1500)
                .numeroPaginas(120)
                .autor(null)
                .build();

        LibroDTO dto1 = LibroDTO.fromEntity(libro1);
        LibroDTO dto2 = LibroDTO.fromEntity(libro2);
        LibroDTO dto3 = LibroDTO.fromEntity(libro3);
        LibroDTO dto4 = LibroDTO.fromEntity(null);

        System.out.println("DTO 1: " + dto1);
        System.out.println("DTO 2: " + dto2);
        System.out.println("DTO 3: " + dto3);
        System.out.println("DTO 4: " + dto4);
    }
}
