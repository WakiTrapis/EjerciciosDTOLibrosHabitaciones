package com.triana.salesianos.ejerciciosdto.ejercicio4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
}
