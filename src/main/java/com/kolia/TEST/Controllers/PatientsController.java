package com.kolia.TEST.Controllers;


import com.kolia.TEST.Models.Patients;
import com.kolia.TEST.Models.Reserve;
import com.kolia.TEST.repos.PatientsRepository;
import com.kolia.TEST.repos.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


@Controller
public class PatientsController
{
    @Autowired
    private PatientsRepository PRep;
    @Autowired
    private ReserveRepository RRep;

    @GetMapping("/Reserved")
    public String Reserved(Model model)
    {
        Iterable<Reserve> AllReserved = RRep.findAll();
        model.addAttribute("Reserved", AllReserved);
        return "reserve";
    }




    @GetMapping("/Patients")
    public String Patients(Model model)
    {
        Iterable<Patients> AllPatients = PRep.findAll();
        model.addAttribute("Patients", AllPatients);

        return "pats";
    }

    @GetMapping("/Patients/add")
    public String Patientss(Model model)
    {
        return "pats-add";
    }

    @PostMapping("/Patients/add")
    public String PatientsAdd(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String middle_name,
                              @RequestParam Integer YoB,
                              @RequestParam String tel,
                              @RequestParam String history,
                              Model model)
    {
        Patients pats = new Patients(name,surname,middle_name,history, ,tel,YoB);
        PRep.save(pats);
        return"redirect:/Patients";
    }

    @GetMapping("/Patients/{id}")
    public String Cards(@PathVariable (value="id") long id, Model model)
    {
        if(!PRep.existsById(id))
            return"redirect:/Patients";
        Optional<Patients> pats = PRep.findById(id);
        ArrayList<Patients> res = new ArrayList<>();
        pats.ifPresent(res::add);
        model.addAttribute("CardID", res);
        return "pats-cards";
    }
    @GetMapping("/Reserved/{id}")
    public String ResAll(@PathVariable (value="id") long id, Model model)
    {
        if(!RRep.existsById(id))
            return"redirect:/Reserved";
        Optional<Reserve> pats = RRep.findById(id);
        ArrayList<Reserve> res = new ArrayList<>();
        pats.ifPresent(res::add);
        model.addAttribute("ResAll", res);
        return "ResF";
    }

    @GetMapping("/Patients/{id}/edit")
    public String CardsEdit(@PathVariable (value="id") long id, Model model)
    {
        if(!PRep.existsById(id))
            return"redirect:/Patients";

        Optional<Patients> pats = PRep.findById(id);
        ArrayList<Patients> res = new ArrayList<>();
        pats.ifPresent(res::add);
        model.addAttribute("CardID", res);
        return "card-edit";

    }

    @PostMapping("/Patients/{id}/edit")
    public String CardUpdate(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String middle_name,
                              @RequestParam Integer YoB,
                              @RequestParam String tel,
                              @RequestParam String history,
                             @PathVariable (value="id") long id,
                              Model model)
    {
        Patients pats = PRep.findById(id).orElseThrow();
        pats.setName(name);
        pats.setSurname(surname);
        pats.setMiddle_name(middle_name);
        pats.setBorn_data(YoB);
        pats.setTel (tel);
        pats.setHistory(history);
        PRep.save(pats);
        return"redirect:/Patients";
    }

    @GetMapping("/Patients/{id}/reserve")
    public String Reserve(@PathVariable (value="id") long id, Model model)
    {


        Optional<Patients> pats = PRep.findById(id);
        ArrayList<Patients> res = new ArrayList<>();
        pats.ifPresent(res::add);
        model.addAttribute("Card", res);


        Optional<Reserve> pats1 = RRep.findById(id);
        ArrayList<Reserve> res1 = new ArrayList<>();
        pats1.ifPresent(res1::add);
        model.addAttribute("res", res1);
        return "reserve-add";
    }

    @PostMapping("/Patients/{id}/reserve")
    public String ReserveAdd(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String middle_name,
                             @RequestParam Integer YoB,
                             @RequestParam String tel,
                             @RequestParam String history,
                             @RequestParam String doctor,
                             @PathVariable (value="id") long id,
                             Model model)
    {



        Reserve patss = new Reserve(name, surname, middle_name, history, group, doctor, policy, email,YoB);
        patss.setName(name);
        patss.setSurname(surname);
        patss.setMiddle_name(middle_name);
        patss.setBorn_data(YoB);
        patss.setTel (tel);
        patss.setHistory(history);
        patss.setDoctor(doctor);
        RRep.save(patss);
        return"redirect:/Reserved";
    }

    @PostMapping("/Patients/{id}/remove")
    public String CardRemove(
                             @PathVariable (value="id") long id,
                             Model model)
    {
        Patients pats = PRep.findById(id).orElseThrow();
        PRep.delete(pats);
        return"redirect:/Patients";
    }

    @PostMapping("/Reserved/{id}/remove")
    public String ReserveRemove(
            @PathVariable (value="id") long id,
            Model model)
    {
        Reserve pats = RRep.findById(id).orElseThrow();
        RRep.delete(pats);
        return"redirect:/Reserved";
    }

    @GetMapping("/Reserved/{id}/edit")
    public String ReserveEdit(@PathVariable (value="id") long id, Model model)
    {
        if(!RRep.existsById(id))
            return"redirect:/Reserved";

        Optional<Reserve> pats = RRep.findById(id);
        ArrayList<Reserve> res = new ArrayList<>();
        pats.ifPresent(res::add);
        model.addAttribute("Res", res);
        return "reserve-edit";

    }

    @PostMapping("/Reserved/{id}/edit")
    public String ReserveUpdate(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String middle_name,
            @RequestParam Integer YoB,
            @RequestParam String tel,
            @RequestParam String history,
            @RequestParam String doctor,
                             @PathVariable (value="id") long id,
                             Model model)
    {

        Reserve pats = RRep.findById(id).orElseThrow();
        pats.setName(name);
        pats.setSurname(surname);
        pats.setMiddle_name(middle_name);
        pats.setBorn_data(YoB);
        pats.setTel(tel);
        pats.setHistory(history);
        pats.setDoctor(doctor);
        RRep.save(pats);
        return"redirect:/Reserved";
    }



}

