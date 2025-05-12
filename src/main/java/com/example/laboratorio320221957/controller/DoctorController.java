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
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("")
    public String listarTodosDoctores(Model model) {
        List<Doctor> listaDoctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores", listaDoctores);
        return "doctores";
    }

    @GetMapping("/{id}/proximas-citas")
    public String listarProximasCitasPorDoctor(@PathVariable("id") Integer id, Model model) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);

        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            List<Paciente> listaProximasCitas = pacienteRepository.findProximasCitasByDoctor(doctor.getId());

            model.addAttribute("doctor", doctor);
            model.addAttribute("listaProximasCitas", listaProximasCitas);
            return "listaProximasCitas";
        } else {
            return "redirect:/doctores";
        }
    }

}