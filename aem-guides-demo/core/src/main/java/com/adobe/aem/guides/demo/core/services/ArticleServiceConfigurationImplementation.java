package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
(
    immediate = true,
    enabled = true,
    name = "ArticleServiceConfiguration osgi component",
    service = Articleconfigurationservice.class
)
@Designate(ocd = ArticleConfiguration.class)
public class ArticleServiceConfigurationImplementation implements Articleconfigurationservice {

    public static final Logger LOG = LoggerFactory.getLogger(ArticleServiceConfigurationImplementation.class);

    private String username;
    private String userid;
    private long phoneno;
    private boolean status;
    private String type;    
    
    
    @Override
    public void ArticleConfiguration() {
        LOG.info("ArticleServiceConfiguration method is  activated");
     
    }

    @Activate
    public void activate(ArticleConfiguration config) {
      LOG.info("ArticleServiceConfiguration activated ");
        configure(config);
        LOG.info("ArticleServiceConfiguration activated with username: {}, userid: {}, phoneno: {}, status: {}, type: {}",
                username, userid, phoneno, status, type);
    }
    @Deactivate
    public void deactivate() {
        LOG.info("ArticleServiceConfiguration deactivated");
    }
    @Modified
    public void modified(ArticleConfiguration config) {
        LOG.info("ArticleServiceConfiguration modified");
        configure(config);
        LOG.info("ArticleServiceConfiguration modified with username: {}, userid: {}, phoneno: {}, status: {}, type: {}",
                username, userid, phoneno, status, type);
    }

    private void configure(ArticleConfiguration config) {
        this.username = config.username();
        this.userid = config.userid();
        this.phoneno = config.phoneno();
        this.status = config.status();
        this.type = config.type();
        LOG.info("Configured ArticleServiceConfiguration with username: {}, userid: {}, phoneno: {}, status: {}, type: {}",
                username, userid, phoneno, status, type);
    }



}
