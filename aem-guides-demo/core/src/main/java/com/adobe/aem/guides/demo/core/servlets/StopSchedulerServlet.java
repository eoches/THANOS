package com.adobe.aem.guides.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.paths=/bin/stopPractiseScheduler",
        "sling.servlet.methods=GET"
    }
)
public class StopSchedulerServlet extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(StopSchedulerServlet.class);
    private static final String JOB_NAME = "SimpleSchedulerJob";

    @Reference
    private Scheduler scheduler;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        scheduler.unschedule(JOB_NAME);
        LOG.info("⛔ Scheduler [{}] has been manually stopped from servlet", JOB_NAME);
        response.getWriter().write("Scheduler has been stopped: " + JOB_NAME);
    }
}
