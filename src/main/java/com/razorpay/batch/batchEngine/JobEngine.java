package com.razorpay.batch.batchEngine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.razorpay.batch.configuration.BatchJobConfig;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobEngine {

    @Autowired
    Job job;

    public Job createJob() {

        return job;
    }

    public boolean processJob() {

        return true;
    }

    @Bean
    public BatchJobConfig getConfig() {

        BatchJobConfig batchJobConfig = null;
        ObjectMapper mapper = new ObjectMapper();
        try {

            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("SampleConfig.json").toURI());

            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            lines.close();

            batchJobConfig = mapper.readValue(data, BatchJobConfig.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  batchJobConfig;

    }

}
