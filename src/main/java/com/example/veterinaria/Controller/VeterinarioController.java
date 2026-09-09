package com.example.veterinaria.Controller;

import com.example.veterinaria.entity.Veterinario;
import com.example.veterinaria.service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    @GetMapping
    public List<Veterinario> listarTodos() {
        return veterinarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Veterinario buscarPorId(@PathVariable Long id) {
        return veterinarioService.buscarPorId(id);
    }

    @PostMapping
    public Veterinario guardar(@RequestBody Veterinario veterinario) {
        return veterinarioService.guardar(veterinario);
    }

    @PutMapping("/{id}")
    public Veterinario actualizar(@PathVariable Long id,
                                  @RequestBody Veterinario veterinario) {

        veterinario.setId(id);

        return veterinarioService.guardar(veterinario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        veterinarioService.eliminar(id);
    }
}