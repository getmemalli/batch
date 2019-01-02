package com.razorpay.batch.configuration;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BatchJobConfig extends AbstractBatchConfiguration {

    String name;

    String version;

    List<I_StepsConfig> stepsConfig;
}
