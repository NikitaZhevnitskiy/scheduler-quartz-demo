package com.zhenik.java.demo.scheduler;

import java.time.Instant;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements org.quartz.Job {

  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("_____________________________________");
    System.out.println("Current:"+ Instant.now().getEpochSecond());
    System.out.println("Description: ["+jobExecutionContext.getTrigger().getDescription()+"] ");
    System.out.println("_____________________________________");

  }
}
