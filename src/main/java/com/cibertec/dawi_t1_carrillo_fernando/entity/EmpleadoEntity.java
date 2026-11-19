package com.cibertec.dawi_t1_carrillo_fernando.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String apellido;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(length = 100)
    private String especialidad;
}
