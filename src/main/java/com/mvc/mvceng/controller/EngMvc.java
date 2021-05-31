package com.mvc.mvceng.controller;

import com.mvc.mvceng.service.Engmvcservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class EngMvc {
    @Autowired
    Engmvcservice engmvcservice ;

    @GetMapping("/")
    public String EngMvc(Model model){
        return "index";
    }
    @GetMapping("/checkeng/{input}")
    public String checkEng(@RequestParam("input")String input , Model model){
      HashMap<String , Integer> answer = engmvcservice.checkWordEng(input);
      List<HashMap<String, Integer>> mapsList = new ArrayList<HashMap<String, Integer>>();
        mapsList.add(answer);
        model.addAttribute("mapsList",mapsList);
        return "answer";
    }


}
