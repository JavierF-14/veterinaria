package com.example.veterinaria.Controller;

import com.example.veterinaria.entity.HistoriaClinica;
import com.example.veterinaria.service.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public List<HistoriaClinica> listarTodos() {
        return historiaClinicaService.listarTodos();
    }

    @GetMapping("/{id}")
    public HistoriaClinica buscarPorId(@PathVariable Long id) {
        return historiaClinicaService.buscarPorId(id);
    }

    @PostMapping
    public HistoriaClinica guardar(@RequestBody HistoriaClinica historiaClinica) {
        return historiaClinicaService.guardar(historiaClinica);
    }

    @PutMapping("/{id}")
    public HistoriaClinica actualizar(@PathVariable Long id,
                                      @RequestBody HistoriaClinica historiaClinica) {
        return historiaClinicaService.actualizar(id, historiaClinica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
    }
}