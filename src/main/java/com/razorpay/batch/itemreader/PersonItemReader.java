package com.razorpay.batch.itemreader;

import com.razorpay.batch.domain.Person;
import net.bytebuddy.utility.RandomString;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class PersonItemReader implements ItemReader<Person> {


    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException
    {
        String firstName = RandomString.make(10);
        String lastName = RandomString.make(10);
        return new Person(firstName, lastName);
    }


}