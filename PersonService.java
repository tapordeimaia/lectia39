package com.example.lectia39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public List<Person> getPersonList(String name){
//        return personRepository.getPersonList();
        return name.isBlank() ? personRepository.getPersonList() : personRepository.getPersonByName(name);
    }

    public void updatePerson(Person person, int id){
        personRepository.updatePerson(person, id);
    };

    public void createPerson(Person person) {
        personRepository.createPerson(person);
    }

    public void deletePerson(int id) {
        personRepository.deletePerson(id);
    }

    public List<Person> getPersonByName(String name) {
       return personRepository.getPersonByName(name);
    }
}
