package com.sling.context.test.core.configs;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = DefaultSiteConfigurationService.class)
@Designate(ocd = DefaultSiteConfigurationService.Configuration.class)
public class DefaultSiteConfigurationService {

    private Configuration configuration = null;

    @Activate
    protected void Activate(Configuration config) {
        configuration = config;
    }

    public String websiteColor() {
        return configuration.websiteColor();
    }

    public String contactEmailAddress() {
        return configuration.contactEmailAddress();
    }

    public int storeID() {
        return configuration.storeID();
    }

    @ObjectClassDefinition(name="com.sling.context.test.core.configs.DefaultSiteConfigurationService")
    public @interface Configuration {
        @AttributeDefinition(
                name = "websiteColor",
                description = "Default website color",
                type = AttributeType.STRING
        )
        String websiteColor();

        @AttributeDefinition(
                name = "contactEmailAddress",
                description = "Default Contact Email Address",
                type = AttributeType.STRING
        )
        String contactEmailAddress();

        @AttributeDefinition(
                name = "storeID",
                description = "Default Store ID",
                type = AttributeType.INTEGER
        )
        int storeID();
    }
} 