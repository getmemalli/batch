package com.razorpay.batch.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.razorpay.batch.domain.Person;
import com.razorpay.batch.itemprocessor.PersonItemProcessor;
import com.razorpay.batch.itemreader.PersonItemReader;
import com.razorpay.batch.itemwriter.PersonItemWriter;
import lombok.Data;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@JsonTypeName("simpleStepsConfig")
public class SimpleStepsConfig implements I_StepsConfig {

    String name;

    ItemReader itemReader = new PersonItemReader();

    ItemWriter itemWriter = new PersonItemWriter();

    ItemProcessor itemProcessor = new PersonItemProcessor();

    Tasklet tasklet;

    /*@Override
    public Step generateStep(StepBuilderFactory stepBuilderFactory) {

        return stepBuilderFactory.get(this.name)
                .<Person, Person>chunk(1)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }*/

    public SimpleStepsConfig() {}

    @Override
    public Step generateStep(StepBuilderFactory stepBuilderFactory) {

        return stepBuilderFactory.get(this.name)
                .<Person, Person>chunk(1)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

}
