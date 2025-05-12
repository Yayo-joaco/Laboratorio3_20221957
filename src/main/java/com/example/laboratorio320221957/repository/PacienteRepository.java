package com.example.laboratorio320221957.repository;

import com.example.laboratorio320221957.entity.Paciente;
import com.example.laboratorio320221957.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospital(Hospital hospital);

    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId AND p.fechaCita > CURRENT_DATE")
    List<Paciente> findProximasCitasByDoctor(@Param("doctorId") Integer doctorId);

    // NUEVO método para derivar pacientes usando @Modifying @Query
    @Modifying
    @Transactional
    @Query("UPDATE Paciente p SET p.doctor.id = :doctorDestinoId WHERE p.doctor.id = :doctorOrigenId")
    int derivarPacientes(@Param("doctorDestinoId") Integer doctorDestinoId,
                         @Param("doctorOrigenId") Integer doctorOrigenId);
}