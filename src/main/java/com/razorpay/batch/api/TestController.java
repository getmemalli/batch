package com.razorpay.batch.api;

import com.razorpay.batch.configuration.BatchJobConfig;
import com.razorpay.batch.configuration.StepsConfig;
import com.razorpay.batch.itemprocessor.PersonItemProcessor;
import com.razorpay.batch.itemreader.PersonItemReader;
import com.razorpay.batch.itemwriter.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class TestController {

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

    @Autowired
    JobLauncher jobLauncher;


    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String index() {
        return "Hello Batch";
    }

    @RequestMapping(value = "/test/process", method = {RequestMethod.GET})
    public Response process() throws Exception {

        processDynamicJob();

        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Processed");

        return Response.ok().entity(response).build();
    }

    @Async
    public String processDynamicJob() throws Exception {

        BatchJobConfig batchJobConfig = new BatchJobConfig();
        batchJobConfig.setName("DynamicJob");

        StepsConfig stepsConfig = new StepsConfig();
        stepsConfig.setName("DynamicStep");
        stepsConfig.setItemReader(personItemReader);
        stepsConfig.setItemWriter(personItemWriter);
        stepsConfig.setItemProcessor(personItemProcessor);

        List<StepsConfig> stepsConfigList = new ArrayList<>();
        stepsConfigList.add(stepsConfig);

        batchJobConfig.setSteps(stepsConfigList);

        JobBuilder dynamicJobBuilder = jobBuilderFactory.get(batchJobConfig.getName());
        Job dynamicJob = dynamicJobBuilder.start(stepsConfig.generateStep(stepBuilderFactory)).build();

        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(dynamicJob, params);


        return "Done";

    }

}
