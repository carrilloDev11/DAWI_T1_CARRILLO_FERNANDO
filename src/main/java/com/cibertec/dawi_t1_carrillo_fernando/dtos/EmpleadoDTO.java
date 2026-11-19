package com.cibertec.dawi_t1_carrillo_fernando.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;
}
