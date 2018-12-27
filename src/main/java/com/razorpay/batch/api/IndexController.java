package com.razorpay.batch.api;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;


@RestController
public class IndexController {

    @Autowired
    Job job;

    @Autowired
    JobLauncher jobLauncher;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index() {
        return "Hello Batch";
    }

    @RequestMapping(value = "/process", method = {RequestMethod.GET},
            consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    public Response process() throws Exception {

        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);

        HashMap<String, Object> respnose = new HashMap<>();
        respnose.put("message", "Processed");

        return Response.ok().entity(respnose).build();
    }

}
