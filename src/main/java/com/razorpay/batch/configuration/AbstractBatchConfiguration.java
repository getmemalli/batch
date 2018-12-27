package com.razorpay.batch.configuration;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractBatchConfiguration {

    @Autowired
    public StepBuilderFactory stepBuilders;

    @Autowired
    public JobBuilderFactory jobBuilders;
}
