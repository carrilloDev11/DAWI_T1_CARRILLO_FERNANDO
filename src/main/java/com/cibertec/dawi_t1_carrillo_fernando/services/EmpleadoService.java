package com.cibertec.dawi_t1_carrillo_fernando.services;

import com.cibertec.dawi_t1_carrillo_fernando.dtos.EmpleadoDTO;
import com.cibertec.dawi_t1_carrillo_fernando.entity.EmpleadoEntity;
import com.cibertec.dawi_t1_carrillo_fernando.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService implements IEmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    @Override
    public List<EmpleadoDTO> listar() {
        return empleadoRepository.findAll().stream()
                .map(empleado -> EmpleadoDTO.builder()
                        .id(empleado.getId())
                        .nombre(empleado.getNombre())
                        .apellido(empleado.getApellido())
                        .email(empleado.getEmail())
                        .especialidad(empleado.getEspecialidad())
                        .build())
                .toList();
    }
    @Override
    public EmpleadoDTO guardar(EmpleadoDTO dto) {
        EmpleadoEntity empleado = EmpleadoEntity.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .especialidad(dto.getEspecialidad())
                .build();

        EmpleadoEntity guardado = empleadoRepository.save(empleado);

        return EmpleadoDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .apellido(guardado.getApellido())
                .email(guardado.getEmail())
                .especialidad(guardado.getEspecialidad())
                .build();
    }
    @Override
    public EmpleadoDTO buscarPorId(Integer id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id).orElseThrow();

        return EmpleadoDTO.builder()
                .id(empleado.getId())
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .email(empleado.getEmail())
                .especialidad(empleado.getEspecialidad())
                .build();
    }
    @Override
    public EmpleadoDTO actualizar(Integer id, EmpleadoDTO dto) {
        EmpleadoEntity empleado = empleadoRepository.findById(id).orElseThrow();

        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmail(dto.getEmail());
        empleado.setEspecialidad(dto.getEspecialidad());

        EmpleadoEntity actualizado = empleadoRepository.save(empleado);

        return EmpleadoDTO.builder()
                .id(actualizado.getId())
                .nombre(actualizado.getNombre())
                .apellido(actualizado.getApellido())
                .email(actualizado.getEmail())
                .especialidad(actualizado.getEspecialidad())
                .build();
    }
    @Override
    public void eliminar(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
