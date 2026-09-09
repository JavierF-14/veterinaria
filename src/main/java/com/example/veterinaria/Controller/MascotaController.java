package com.example.veterinaria.Controller;

import com.example.veterinaria.entity.Mascota;
import com.example.veterinaria.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @GetMapping
    public List<Mascota> listarTodos() {
        return mascotaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Mascota buscarPorId(@PathVariable Long id) {
        return mascotaService.buscarPorId(id);
    }

    @PostMapping
    public Mascota guardar(@RequestBody Mascota mascota) {
        return mascotaService.guardar(mascota);
    }

    @PutMapping("/{id}")
    public Mascota actualizar(@PathVariable Long id,
                              @RequestBody Mascota mascota) {
        return mascotaService.actualizar(id, mascota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
    }
    @PostMapping("/{mascotaId}/veterinarios/{veterinarioId}")
    public Mascota agregarVeterinario(@PathVariable Long mascotaId,
                                      @PathVariable Long veterinarioId) {
        return mascotaService.agregarVeterinario(mascotaId, veterinarioId);
    }
}