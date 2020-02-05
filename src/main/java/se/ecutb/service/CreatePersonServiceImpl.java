package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.data.PersonRepository;
import se.ecutb.dto.PersonDto;
import se.ecutb.model.AbstractPersonFactory;
import se.ecutb.model.Address;
import se.ecutb.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePersonServiceImpl extends AbstractPersonFactory implements CreatePersonService  {
    private List<Person> persons = new ArrayList<>();
    @Autowired
    private IdSequencers idSequencers;
    @Override
    public Person create(String firstName, String lastName, String email) throws IllegalArgumentException {
        if(persons.contains(email)){
            throw new IllegalArgumentException();
        }
        Person person = createNewPerson(idSequencers.nextPersonId(),firstName,lastName,email,null);
        persons.add(person);
        return person;
    }

    @Override
    public Person create(String firstName, String lastName, String email, Address address) throws IllegalArgumentException {
        if(persons.contains(email)){
            throw new IllegalArgumentException();
        }
        Person person= createNewPerson(idSequencers.nextPersonId(),firstName,lastName,email,address);
        persons.add(person);
        return person;
    }
}
