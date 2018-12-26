package com.razorpay.batch.itemprocessor;

import com.razorpay.batch.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonItemProcessor implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person person) throws Exception
    {
        if(person == null) {
            throw new Exception();
        }
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        log.info(firstName);
        return new Person(firstName, lastName);
    }
}