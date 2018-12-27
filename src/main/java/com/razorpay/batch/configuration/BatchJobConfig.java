package com.razorpay.batch.configuration;

import lombok.Data;

import java.util.List;

@Data
public class BatchJobConfig extends AbstractBatchConfiguration {

    String name;

    List<StepsConfig> steps;
}
