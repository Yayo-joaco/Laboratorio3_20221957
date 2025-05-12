package com.example.laboratorio320221957.controller;

import com.example.laboratorio320221957.entity.Hospital;
import com.example.laboratorio320221957.entity.Doctor;
import com.example.laboratorio320221957.entity.Paciente;
import com.example.laboratorio320221957.repository.HospitalRepository;
import com.example.laboratorio320221957.repository.DoctorRepository;
import com.example.laboratorio320221957.repository.PacienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    @GetMapping("")
    public String listHospital(Model model) {
        List<Hospital> hospitalList = hospitalRepository.findAll();
        model.addAttribute("hospitalList", hospitalList);
        return "hospital";
    }

    @GetMapping("/{id}/doctores")
    public String listarDoctoresPorHospital(@PathVariable("id") Integer id, Model model) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            List<Doctor> listaDoctores = doctorRepository.findByHospital(hospital);

            model.addAttribute("hospital", hospital);
            model.addAttribute("listaDoctores", listaDoctores);
            return "listaDoctores";
        } else {
            return "redirect:/hospital";
        }
    }

    @GetMapping("/{id}/pacientes")
    public String listarPacientesPorHospital(@PathVariable("id") Integer id, Model model) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            List<Paciente> listaPacientes = pacienteRepository.findByHospital(hospital);

            model.addAttribute("hospital", hospital);
            model.addAttribute("listaPacientes", listaPacientes);
            return "listaPacientes";
        } else {
            return "redirect:/hospital";
        }
    }
}