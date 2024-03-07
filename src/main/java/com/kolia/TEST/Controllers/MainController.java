package com.kolia.TEST.Controllers;

import com.kolia.TEST.Models.Patients;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;




@Controller
public class MainController
{

    @GetMapping("/")
    public String Home(Model model)
    {
        model.addAttribute("title", "Главная страница");
        return "home";


    }



}

