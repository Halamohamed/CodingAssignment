package se.ecutb.data;

import se.ecutb.model.Address;
import se.ecutb.model.Person;

import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl implements PersonRepository {

    
    @Override
    public Optional<Person> findById(int personId) {
        return Optional.empty();
    }

    @Override
    public Person persist(Person person) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Person> findByAddress(Address address) {
        return null;
    }

    @Override
    public List<Person> findByCity(String city) {
        return null;
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Person> findByFullName(String fullName) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public boolean delete(int personId) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void clear() {

    }
}
