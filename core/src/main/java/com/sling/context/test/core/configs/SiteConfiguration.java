package com.sling.context.test.core.configs;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label="Website Configuration", description="Configuration can be made per website")
public @interface SiteConfiguration {

    @Property(label="Website Color", description="Painting website color of your choice.")
    String websiteColor() default "Color From Default in OSGI";

    @Property(label="Contact Email Address", description="Sending an email using the web form will inform this email address.")
    String contactEmailAdress() default "osgi-email-default@gmail.com";

    @Property(label="Store Number ID", description="Store number will be displayed bottom right of the page")
    int storeID() default 0;
}