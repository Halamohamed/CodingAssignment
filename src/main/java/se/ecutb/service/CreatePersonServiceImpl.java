package se.ecutb.service;

import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.data.PersonRepository;
import se.ecutb.model.AbstractPersonFactory;
import se.ecutb.model.Address;
import se.ecutb.model.Person;

@Component
public class CreatePersonServiceImpl extends AbstractPersonFactory implements CreatePersonService  {
    private PersonRepository repository;
    private IdSequencers idSequencers;
    @Override
    public Person create(String firstName, String lastName, String email) throws IllegalArgumentException {
        if(repository.findAll().contains(email)){
            throw new IllegalArgumentException();
        }
        return createNewPerson(idSequencers.nextPersonId(),firstName,lastName,email,null);
    }

    @Override
    public Person create(String firstName, String lastName, String email, Address address) throws IllegalArgumentException {
        return createNewPerson(idSequencers.nextPersonId(),firstName,lastName,email,address);
    }
}
