package com.example.lectia39.controller;

import com.example.lectia39.Person;
import com.example.lectia39.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPersonList(@RequestParam(defaultValue = "") String name) {
        return personService.getPersonList(name);
    }

    //    @GetMapping("/name")
//    public List<Person> getPersonbyName(@RequestParam String name){
//        return personService.getPersonByName(name);
//    }
//    @PutMapping("/{id}")
//    public void updatePerson(@RequestBody Person person, @PathVariable("id") int id) {
//        personService.updatePerson(person, id);
//    }

    @PostMapping("/create")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }

    @PatchMapping("/patch/{id}")
    public void patchPerson(@RequestBody Person person, @PathVariable("id") int id){
        personService.patchPerson(person, id);
    }
}
