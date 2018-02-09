package com.zhenik.java.demo.scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class Boot {
  private static final String GROUP = "infosak-scheduler";

  public static void main(String[] args) throws SchedulerException {

    // Grab the Scheduler instance from the Factory
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

    // define the job and tie it to our MyJob class
    JobDetail job = newJob(MyJob.class)
        .withIdentity("release-cases", GROUP)
        .build();

    // Trigger the job to run now, and then repeat every 10 seconds
    Trigger trigger = newTrigger()
        .withIdentity("IN_PROGRESS_to_NEW_1h", GROUP)
        .startNow()
        .withSchedule(simpleSchedule()
            .withIntervalInSeconds(10)
            .repeatForever())
        .withDescription("Release cases with status IN_PROGRESS to NEW if they in progress more than 1h")
        .build();

    // Tell quartz to schedule the job using our trigger
    scheduler.scheduleJob(job, trigger);

    // and start it off
    scheduler.start();

  }
}
