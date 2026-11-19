package com.cibertec.dawi_t1_carrillo_fernando.controllers;


import com.cibertec.dawi_t1_carrillo_fernando.dtos.EmpleadoDTO;
import com.cibertec.dawi_t1_carrillo_fernando.services.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final IEmpleadoService empleadoService;
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listar() {
        return ResponseEntity.ok(empleadoService.listar());
    }
    @PostMapping
    public ResponseEntity<EmpleadoDTO> guardar(@RequestBody EmpleadoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.guardar(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoService.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizar(@PathVariable Integer id, @RequestBody EmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoService.actualizar(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}