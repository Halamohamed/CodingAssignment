package se.ecutb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.ecutb.config.AppConfig;
import se.ecutb.data.PersonRepository;
import se.ecutb.model.Address;
import se.ecutb.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        PersonRepository personRepository = context.getBean(PersonRepository.class);
        Person person =new Person(1, "Hala","Mohammed","hala@gmail.com",new Address("halagatan","106","Karlshamn"));
        System.out.println(personRepository.persist(person));
        System.out.println(personRepository.findById(1));

    }
}
