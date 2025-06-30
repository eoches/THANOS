package com.adobe.aem.guides.demo.core.schedulers;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true, 
    service = Runnable.class
    )
public class PractiseSchedulerStart implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(PractiseSchedulerStart.class);

    @Reference
    private Scheduler scheduler;

   @Activate
    protected void activate() {
        ScheduleOptions options = scheduler.EXPR("0/15 * * * * ?"); // every 15 sec
        options.name("SimpleSchedulerJob");
        scheduler.schedule(this, options);
    }

@Override
public void run() {
    LOG.info("SimpleScheduler ran at: {}", new java.util.Date());
}

}
