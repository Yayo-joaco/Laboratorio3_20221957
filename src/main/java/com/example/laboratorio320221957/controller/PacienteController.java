package com.example.laboratorio320221957.controller;

import com.example.laboratorio320221957.entity.Paciente;
import com.example.laboratorio320221957.entity.Doctor;
import com.example.laboratorio320221957.repository.PacienteRepository;
import com.example.laboratorio320221957.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("")
    public String listarTodosPacientes(Model model) {
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        model.addAttribute("listaPacientes", listaPacientes);
        return "pacientes";
    }

    @GetMapping("/derivar")
    public String mostrarFormularioDerivar(Model model) {
        List<Doctor> listaDoctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores", listaDoctores);
        return "formDerivarPaciente";
    }

    @PostMapping("/derivar")
    public String procesarDerivacionPacientes(
            @RequestParam("doctorOrigenId") Integer doctorOrigenId,
            @RequestParam("doctorDestinoId") Integer doctorDestinoId) {


        if (doctorOrigenId != null && doctorDestinoId != null && !doctorOrigenId.equals(doctorDestinoId)) {
            pacienteRepository.derivarPacientes(doctorDestinoId, doctorOrigenId);
        }

        return "redirect:/pacientes";
    }


}