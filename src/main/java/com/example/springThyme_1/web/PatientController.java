package com.example.springThyme_1.web;

import com.example.springThyme_1.dao.PatientRepository;
import com.example.springThyme_1.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/patients")
    public String list(Model model,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "5") int size,
                       @RequestParam(name = "keyword", defaultValue = "") String mc
    ) {
        Page<Patient> patientPage = patientRepository.findByNameContains(mc, PageRequest.of(page, size));
        model.addAttribute("patients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size",size);
        model.addAttribute("keyword", mc);
        return "patients";
    }

    @GetMapping(path = "/deletePatient")
    public String delete(Long id,String keyword,int page,int size) {
        patientRepository.deleteById(id);
        return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
    }

    @GetMapping(path = "/deletePatient1")
    public String delete(Long id,String keyword,int page,int size,Model model) {
        patientRepository.deleteById(id);
        return list(model,page,size,keyword);
    }
}
