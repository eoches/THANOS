package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
(
    immediate = true,
    enabled = true,
    name = "PressRelease osgi component"
)
public class PressRelease {
    
    public static final Logger LOG = LoggerFactory.getLogger(PressRelease.class);

    @Reference
    private ArticleService articleService;

    @Activate
    public void activate() {
        LOG.info("PressRelease activated");
        LOG.info("Article message: {}", articleService.getArticleMessage());
    }

    @Deactivate
    public void deactivate() {
        LOG.info("PressRelease deactivated");
    }
    @Modified
    public void modified() {
        LOG.info("PressRelease modified");
    }   
    

}
