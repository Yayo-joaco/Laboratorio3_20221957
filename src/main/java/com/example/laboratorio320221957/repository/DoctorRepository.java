package com.example.laboratorio320221957.repository;

import com.example.laboratorio320221957.entity.Doctor;
import com.example.laboratorio320221957.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByHospital(Hospital hospital);

}
