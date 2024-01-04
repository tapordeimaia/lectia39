package com.example.lectia39;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    int idCount = 0;
    private List<Person> personList = new ArrayList<>();

    public PersonRepository() {
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void updatePerson(Person person, int id) {
        Person p = personList.stream()
                .filter(pers -> pers.getId() == id)
                .findFirst().get();
        p.setName(person.getName());
        p.setAge(person.getAge());
        p.setSurname(person.getSurname());
    }

    public void createPerson(Person person) {
        person.setId(++idCount);
        personList.add(person);
    }

    public void deletePerson(int id) {
        personList = personList.stream()
                .filter(p->p.getId()!=id)
                .collect(Collectors.toList());
    }

    public List<Person> getPersonByName(String name) {
        return personList.stream()
                .filter(p->p.getName().equals(name))
                .collect(Collectors.toList());
    }
}
