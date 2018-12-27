package com.razorpay.batch;

import com.razorpay.batch.domain.Person;
import com.razorpay.batch.itemprocessor.PersonItemProcessor;
import com.razorpay.batch.itemreader.PersonItemReader;
import com.razorpay.batch.itemwriter.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;


@Configuration
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PersonItemProcessor personItemProcessor;

    @Autowired
    private PersonItemReader personItemReader;

    @Autowired
    private PersonItemWriter personItemWriter;

    @Bean
    public Job importUserJob(Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .start(step1)
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public PersonItemProcessor processor() {
        return personItemProcessor;
    }

    @Bean
    public PersonItemReader reader() {
        return personItemReader;
    }

    @Bean
    public PersonItemWriter writer() {
        return personItemWriter;
    }

}
