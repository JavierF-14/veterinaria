package com.example.veterinaria.service;

import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.entity.Veterinario;
import com.example.veterinaria.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceimp implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    @Override
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Veterinario no encontrado con id: " + id));
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario actualizar(Long id, Veterinario veterinario) {

        Veterinario existente = buscarPorId(id);

        existente.setNombre(veterinario.getNombre());
        existente.setTarjetaProfesional(veterinario.getTarjetaProfesional());
        existente.setEspecialidad(veterinario.getEspecialidad());
        existente.setCorreo(veterinario.getCorreo());

        return veterinarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {

        Veterinario veterinario = buscarPorId(id);

        veterinarioRepository.delete(veterinario);
    }
}