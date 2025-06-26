package com.adobe.aem.guides.demo.core.services.implemntation;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.demo.core.services.ArticleService;

@Component(
    immediate = true,
    enabled = true,
    name = "ArticleService osgi component",
    service = ArticleService.class
)
public class ArticleServiceImpl implements ArticleService {

    public static final Logger LOG = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Activate
    public void activate(ComponentContext context) {
        LOG.info("ArticleService activated {}", context.getProperties());
    }

    @Deactivate
    public void deactivate(ComponentContext context) {
        LOG.info("ArticleService deactivated {}", context.getProperties());
    }

    @Modified
    public void modified() {
        LOG.info("ArticleService modified");
    }

    @Override
    public String getArticleMessage() {
        return "This is an article message from the ArticleService.";
    }
   
}
  