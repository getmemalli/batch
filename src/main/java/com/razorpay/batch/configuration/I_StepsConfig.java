package com.razorpay.batch.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.NoClass;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = NoClass.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleStepsConfig.class, name = "simpleStepsConfig")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public interface I_StepsConfig {

    Step generateStep(StepBuilderFactory stepBuilderFactory);
}
