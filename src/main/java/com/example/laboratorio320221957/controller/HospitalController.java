package com.example.laboratorio320221957.controller;


import com.example.laboratorio320221957.entity.Hospital;
import com.example.laboratorio320221957.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping("")
    public String listHospital(Model model) {
        List<Hospital> list;

        list = hospitalRepository.findAll();
        model.addAttribute("hospitalList", list);
        return "list";
    }
}
