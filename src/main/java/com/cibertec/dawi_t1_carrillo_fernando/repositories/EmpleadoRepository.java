package com.cibertec.dawi_t1_carrillo_fernando.repositories;

import com.cibertec.dawi_t1_carrillo_fernando.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
}