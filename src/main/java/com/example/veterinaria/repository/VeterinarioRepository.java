package com.example.veterinaria.repository;

import com.example.veterinaria.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario,Long> {
}
