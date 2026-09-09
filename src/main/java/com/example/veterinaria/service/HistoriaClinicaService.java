package com.example.veterinaria.service;

import com.example.veterinaria.entity.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {

    List<HistoriaClinica> listarTodos();

    HistoriaClinica buscarPorId(Long id);

    HistoriaClinica guardar(HistoriaClinica historiaClinica);

    HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica);

    void eliminar(Long id);
}