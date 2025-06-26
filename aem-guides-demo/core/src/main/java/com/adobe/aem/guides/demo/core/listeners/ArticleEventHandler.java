package com.adobe.aem.guides.demo.core.listeners;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.service.event.EventConstants;

@Component(
    service = EventHandler.class,
    immediate = true,
    enabled = true,
    property = {
        EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
        EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
        EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/REMOVED",
        EventConstants.EVENT_TOPIC + "=com/day/cq/wcm/core/event/PageEvent/ACTIVATED",
        // EventConstants.EVENT_FILTER + "=(path=/content/Demo/*)"
    }
)
public class ArticleEventHandler implements EventHandler {

    public static final Logger LOG = LoggerFactory.getLogger(ArticleEventHandler.class);

    @Override
    public void handleEvent(Event event) {
       LOG.info("Info: Event Handler is executed.....");
       LOG.info("Topic Name: {}", event.getTopic());
       String[] names = event.getPropertyNames();
         if (names != null) {
              for (String name : names) {
                LOG.info("Property Name: {}, Value: {}", name, event.getProperty(name).toString());
              }
         } else {
              LOG.info("No properties found in the event.");
         }  
    }

}
