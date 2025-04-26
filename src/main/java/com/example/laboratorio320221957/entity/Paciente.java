package com.example.laboratorio320221957.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "id")
    private String id;
    private String nombre;
    private Integer edad;
    private String genero;
    private String diagnostico;
    private String fechaCita;
    private Integer numeroHabitacion;
    @Id
    @Column(name = "doctor_id")
    private String doctorID;
    @Id
    @Column(name = "hospital_id")
    private String hospitalID;

    public Paciente() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public String getFechaCita() { return fechaCita; }
    public void setFechaCita(String fechaCita) { this.fechaCita = fechaCita; }
    public Integer getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(Integer numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }
    public String getHospitalID() { return hospitalID; }
    public void setHospitalID(String hospitalID) { this.hospitalID = hospitalID; }

}
