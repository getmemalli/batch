package com.razorpay.batch.itemwriter;

import com.razorpay.batch.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class PersonItemWriter implements ItemWriter<Person> {

    @Override
    public void write(List<? extends Person> items) throws Exception {
        log.info(items.toString());
        items.stream().forEach(System.out::println);
    }
}
