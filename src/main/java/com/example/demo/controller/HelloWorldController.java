package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Patrik Melander
 * Date: 2021-04-08
 * Time: 10:41
 * Project: demo
 * Copyright: MIT
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index(){
        return "Hello world";
    }
    @RequestMapping("/a")
    public String index2(){
        return "Hello woooooorld";
    }
    @RequestMapping("/b")
    public String index3(@RequestParam (required = false) String name){
        if (name==null)
            return "Hello World";

        return "Hello " + name;
    }
    @RequestMapping("/c")
    public String index4(@RequestParam (defaultValue = "World") String name){
        return "Hello " + name;
    }

    @RequestMapping("/d")
    public String index5(@RequestParam (defaultValue = "firstName") String firstName,
                         @RequestParam (defaultValue = "lastName") String lastName)
    {
        return "Hello " + firstName + " " + lastName;
    }

    @RequestMapping("/random")
    public String index6()
    {
        Random random = new Random();
        int r = random.nextInt(11);
        return "Ditt nr är " + r;
    }
    @RequestMapping("/luckyYou")
    public String index7(@RequestParam (defaultValue = "wrongInput") String luck)
    {
        if (luck.equals("animal")) {
            List<String> luckyAnimals = new ArrayList<>();
            luckyAnimals.add("Hund");
            luckyAnimals.add("Katt");
            luckyAnimals.add("Apa");
            luckyAnimals.add("Pingvin");

            Random random = new Random();
            int r = random.nextInt(4);
            return "Ditt lycko-djur är " + luckyAnimals.get(r) + " " + r;

    }else if (luck.equals("number")){
            Random random = new Random();
            int r = random.nextInt(99);
            return "Ditt lycko-nr är " + r;
    }

     return "Mata in animal eller number för att se ditt lycko djur eller lyckonr";
    }

    //Tar emot en lista // http://localhost:8080/list?names=Patrik,Julia,Oscar
    @RequestMapping("/list")
    public String index8(@RequestParam List<String> names) {
        return "Hello " + names;
    }

    // Tar emot variabeln som en del av pathen // http://localhost:8080/pathVariable/Patrik
    @RequestMapping("pathVariable/{name}")
    public String index9(@PathVariable String name){
        if (name==null) return "Hello World";
        return "Hello " + name;
    }



}
