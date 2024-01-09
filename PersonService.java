package com.example.lectia39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepositoryJPA personRepository;

    public List<Person> getPersonList(String name) {
//        return personRepository.getPersonList();
        return name.isBlank() ? personRepository.findAll() : personRepository.findAllByName(name);
    }

    public void updatePerson(Person person, int id) {
        Person p = personRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Nu exista persoana cu id " + id));
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        p.setAge(person.getAge());
        personRepository.save(p);
//        personRepository.updatePerson(person, id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
//        personRepository.createPerson(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
//
//    public List<Person> getPersonByName(String name) {
//        return personRepository.getPersonByName(name);
//    }
//
    public void patchPerson(Person person, int id) {
        Person p = personRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("Nu esxista persoana cu id "+id));
        if(person.getSurname()!=null){
            p.setSurname(person.getSurname());
        }
        if(person.getAge()!=0){
            p.setAge(person.getAge());
        }
        if(person.getName()!=null){
            p.setName(person.getName());
        }
        personRepository.save(p);
//        personRepository.patchPerson(person, id);
    }
}
