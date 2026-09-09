package com.example.veterinaria.service;

import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.entity.Mascota;
import com.example.veterinaria.repository.MascotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.veterinaria.entity.Veterinario;
import com.example.veterinaria.repository.VeterinarioRepository;
import com.example.veterinaria.Exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotaServiceimp implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Override
    public List<Mascota> listarTodos() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Mascota no encontrada con id: " + id));
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Long id, Mascota mascota) {

        Mascota existente = buscarPorId(id);

        existente.setNombre(mascota.getNombre());
        existente.setEspecie(mascota.getEspecie());
        existente.setRaza(mascota.getRaza());
        existente.setEdad(mascota.getEdad());
        existente.setPeso(mascota.getPeso());

        return mascotaRepository.save(existente);
    }



    @Override
    public void eliminar(Long id) {

        Mascota mascota = buscarPorId(id);

        mascotaRepository.delete(mascota);
    }


    @Override
    public Mascota agregarVeterinario(Long mascotaId, Long veterinarioId) {

        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada"));

        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado"));

        mascota.getVeterinarios().add(veterinario);

        return mascotaRepository.save(mascota);
    }
}
