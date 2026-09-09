package com.example.veterinaria.service;

import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.entity.HistoriaClinica;
import com.example.veterinaria.repository.HistoriaClinicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceimp implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public List<HistoriaClinica> listarTodos() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica buscarPorId(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Historia clinica no encontrada con id: " + id));
    }

    @Override
    public HistoriaClinica guardar(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica) {

        HistoriaClinica existente = buscarPorId(id);

        existente.setFechaApertura(historiaClinica.getFechaApertura());
        existente.setAntecedentes(historiaClinica.getAntecedentes());
        existente.setObservaciones(historiaClinica.getObservaciones());

        return historiaClinicaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        HistoriaClinica historia = buscarPorId(id);
        historiaClinicaRepository.delete(historia);
    }
}