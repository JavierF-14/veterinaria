package com.example.veterinaria.service;

import com.example.veterinaria.entity.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodos();

    Mascota buscarPorId(Long id);

    Mascota guardar(Mascota mascota);

    Mascota actualizar(Long id, Mascota mascota);

    Mascota agregarVeterinario(Long mascotaId, Long veterinarioId);

    void eliminar(Long id);
}
