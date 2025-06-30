package com.adobe.aem.guides.demo.core.listeners;

import org.apache.sling.api.resource.observation.ResourceChange;
import org.apache.sling.api.resource.observation.ResourceChangeListener;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component(
    immediate = true,
    service = ResourceChangeListener.class,
    property = {
        ResourceChangeListener.PATHS + "=/content/we-retail",
        ResourceChangeListener.CHANGES + "=" + "ADDED",
        ResourceChangeListener.CHANGES + "=" + "CHANGED",
        ResourceChangeListener.CHANGES + "=" + "REMOVED"
    }
    )
public class ArticleEventListner implements ResourceChangeListener {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleEventListner.class);

    @Override
    public void onChange(List<ResourceChange> changes) {
        for (ResourceChange change : changes) {
            LOG.info("Resource Change Detected: {} at path {}", change.getType(), change.getPath());
        }
    }
}

