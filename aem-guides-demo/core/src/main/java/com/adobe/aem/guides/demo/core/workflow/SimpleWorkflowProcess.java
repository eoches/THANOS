package com.adobe.aem.guides.demo.core.workflow;


import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.adobe.granite.workflow.WorkflowException;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = WorkflowProcess.class,
    property = {
        "process.label=Simple Payload Logger"
    }
)
public class SimpleWorkflowProcess implements WorkflowProcess {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
            throws WorkflowException {

        // Get payload path
        String path = workItem.getWorkflowData().getPayload().toString();

        // Log the payload path
        LOG.info("Payload path: {}", path);
    }
}

    