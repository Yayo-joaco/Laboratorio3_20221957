package com.example.laboratorio320221957.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEpecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Hospital getHospital() {
        return hospital;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}