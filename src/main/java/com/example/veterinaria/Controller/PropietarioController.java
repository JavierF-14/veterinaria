package com.example.veterinaria.Controller;

import com.example.veterinaria.entity.Propietario;
import com.example.veterinaria.service.PropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
@RequiredArgsConstructor
public class PropietarioController {

    private final PropietarioService propietarioService;

    @GetMapping
    public List<Propietario> listarTodos() {
        return propietarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Propietario buscarPorId(@PathVariable Long id) {
        return propietarioService.buscarPorId(id);
    }

    @PostMapping
    public Propietario guardar(@RequestBody Propietario propietario) {
        return propietarioService.guardar(propietario);
    }

    @PutMapping("/{id}")
    public Propietario actualizar(@PathVariable Long id,
                                  @RequestBody Propietario propietario) {
        return propietarioService.actualizar(id, propietario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
    }
}