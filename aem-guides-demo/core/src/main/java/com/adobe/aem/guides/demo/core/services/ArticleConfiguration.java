package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition
(
    name = "Article Service Configuration",
    description = "Configuration for the Article Service"
)
public @interface ArticleConfiguration {
    @AttributeDefinition(
        name = "username",
        description = "The username for the article service",
        defaultValue = "admin",
        required = true,
        type = AttributeType.STRING
    )
    String username() default "admin";

       @AttributeDefinition(
        name = "userid",
        description = "The userid for the article service",
        defaultValue = "admin",
        required = true,
        type = AttributeType.STRING
    )
    String userid() default "admin";

       @AttributeDefinition(
        name = "phone number",
        description = "The phone number of user for the article service",
        defaultValue = "9999999999",
        required = true,
        type = AttributeType.LONG
    )
    long phoneno() default 9999999999L;

      @AttributeDefinition(
        name = "status",
        description = "The status of user for the article service",
        defaultValue = "true",
        required = true,
        type = AttributeType.BOOLEAN
    )
    boolean status() default false;

     @AttributeDefinition(
        name = "type",
        description = "The type of user for the article service",
        options = {
            @Option(label = "Active", value = "active"),
            @Option(label = "Inactive", value = "inactive")
        },
        required = true,
        type = AttributeType.STRING
    )
    String type() default "active";

}
