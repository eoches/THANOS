package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PractiseKrishnaReddyModel {

    // Tab 1 - Basic Info
    @ValueMapValue
    private String title;

    @ValueMapValue
    private int number;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String publishDate;

    @ValueMapValue
    private boolean isActive;

    // Tab 2 - Tags and Topics
    @ValueMapValue
    private String section;

    @ValueMapValue
    private String author;

    @Inject
    private List<String> topics;

    // Tab 3 - Links (Composite Multifield)
    @ChildResource(name = "links")
    private List<PractiseLinkItem> links;

    // Getters
    public String getTitle() { return title; }

    public int getNumber() { return number; }

    public String getDescription() { return description; }

    public String getPublishDate() { return publishDate; }

    public boolean isActive() { return isActive; }

    public String getSection() { return section; }

    public String getAuthor() { return author; }

    public List<String> getTopics() { return topics; }

    public List<PractiseLinkItem> getLinks() { return links; }
}
