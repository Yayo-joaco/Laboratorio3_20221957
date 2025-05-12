package com.example.laboratorio320221957.repository;

import com.example.laboratorio320221957.entity.Paciente;
import com.example.laboratorio320221957.entity.Hospital; // Importar Hospital
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> { // Asegúrate que el ID sea Integer si corregiste la entidad

    List<Paciente> findByHospital(Hospital hospital);

}