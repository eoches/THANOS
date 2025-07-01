package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PractiseLinkItem {

    @ValueMapValue
    private String linkTitle;

    @ValueMapValue
    private String linkUrl;

    @ValueMapValue
    private String linkDate;

    // Getters
    public String getLinkTitle() { return linkTitle; }

    public String getLinkUrl() { return linkUrl; }

    public String getLinkDate() { return linkDate; }
}

