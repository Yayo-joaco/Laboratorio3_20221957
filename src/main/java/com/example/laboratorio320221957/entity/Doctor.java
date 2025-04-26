package com.example.laboratorio320221957.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "id")
    private String id;
    private String nombre;
    private String especialidad;
    @Id
    @Column(name = "hospital_id")
    private Integer hospitalID;
    private String countryName;

    public Doctor() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public Integer getHospitalId() { return hospitalID; }
    public void setHospitalId(Integer hospitalId) { this.hospitalID = hospitalId; }
}
