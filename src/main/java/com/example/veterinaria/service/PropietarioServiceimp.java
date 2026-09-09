package com.example.veterinaria.service;

import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.entity.Propietario;
import com.example.veterinaria.repository.PropietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropietarioServiceimp implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario buscarPorId(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Propietario no encontrado con id: " + id));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietario) {

        Propietario existente = buscarPorId(id);

        existente.setNombre(propietario.getNombre());
        existente.setDocumento(propietario.getDocumento());
        existente.setTelefono(propietario.getTelefono());
        existente.setCorreo(propietario.getCorreo());

        return propietarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {

        Propietario propietario = buscarPorId(id);

        propietarioRepository.delete(propietario);
    }
}
