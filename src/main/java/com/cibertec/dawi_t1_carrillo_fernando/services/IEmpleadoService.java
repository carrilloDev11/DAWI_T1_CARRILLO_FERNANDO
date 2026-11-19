package com.cibertec.dawi_t1_carrillo_fernando.services;

import com.cibertec.dawi_t1_carrillo_fernando.dtos.EmpleadoDTO;
import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDTO> listar();
    EmpleadoDTO guardar(EmpleadoDTO dto);
    EmpleadoDTO buscarPorId(Integer id);
    EmpleadoDTO actualizar(Integer id, EmpleadoDTO dto);
    void eliminar(Integer id);
}