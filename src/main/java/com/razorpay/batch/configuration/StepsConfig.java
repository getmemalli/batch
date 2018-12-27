package com.razorpay.batch.configuration;

import com.razorpay.batch.domain.Person;
import lombok.Data;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Data
@Component
public class StepsConfig {

    String name;

    ItemReader itemReader;

    ItemWriter itemWriter;

    ItemProcessor itemProcessor;

    Tasklet tasklet;

    public Step generateStep(StepBuilderFactory stepBuilderFactory) {

        return stepBuilderFactory.get(this.name)
                .<Person, Person>chunk(1)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }
}
