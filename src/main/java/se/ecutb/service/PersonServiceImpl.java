package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.data.PersonRepository;
import se.ecutb.dto.PersonDto;
import se.ecutb.dto.PersonDtoWithTodo;
import se.ecutb.model.Address;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CreatePersonService createPersonService;
    @Autowired
    private PersonDtoConversionService personDtoConversionService;
    @Autowired
    private PersonService personService;
    @Autowired
    private IdSequencers idSequencers;

    @Override
    public Person createPerson(String firstName, String lastName, String email, Address address) {
        Person person = null;
        if(!personRepository.findAll().contains(email)){
             person = createPersonService.create(firstName,lastName,email,address);
            personRepository.persist(person);
        }

         return person;
    }

    @Override
    public List<PersonDto> findAll() {
        return personService.findAll();
    }

    @Override
    public PersonDto findById(int personId) throws IllegalArgumentException {

        return personService.findById(personId);
    }

    @Override
    public Person findByEmail(String email) throws IllegalArgumentException {
        if(personRepository.findByEmail(email).isPresent()){
            return null;
        }

        return personRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<PersonDtoWithTodo> findPeopleWithAssignedTodos() {


        return null;
    }

    @Override
    public List<PersonDto> findAllPeopleWithNoTodos() {
        return null;
    }

    @Override
    public List<PersonDto> findPeopleByAddress(Address address) {
        return personRepository.findByAddress(address)
                .stream().map(person -> new PersonDto(person.getPersonId(),person.getFirstName(),person.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> findPeopleByCity(String city) {
        return personRepository.findByCity(city).stream()
                .map(person -> new PersonDto(person.getPersonId(),person.getFirstName(),person.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> findByFullName(String fullName) {
        return personRepository.findAll().stream()
                .map(person -> new PersonDto(person.getPersonId(),person.getFirstName(),person.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> findByLastName(String lastName) {
        List<PersonDto> personDtos = personRepository.findByLastName(lastName).stream()
                .map(person -> new PersonDto(person.getPersonId(),person.getFirstName(),person.getLastName()))
                .collect(Collectors.toList());
        return personDtos;
    }

    @Override
    public boolean deletePerson(int personId) throws IllegalArgumentException {
        if(!personRepository.findById(personId).isPresent()){
            throw new IllegalArgumentException();
        }
        return personRepository.delete(personId);
    }
}
