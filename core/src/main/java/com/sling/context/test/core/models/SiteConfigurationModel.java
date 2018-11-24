package com.sling.context.test.core.models;

import com.day.cq.wcm.api.Page;
import com.sling.context.test.core.configs.SiteConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class)
public class SiteConfigurationModel {


    @ScriptVariable(name = "currentPage")
    private Page page;

    private SiteConfiguration config = null;

    @PostConstruct
    private void init() {
        config = page.adaptTo(ConfigurationBuilder.class).as(SiteConfiguration.class);
    }

    public String getWebsiteColor() {
        return config.websiteColor();
    }

    public String getContactEmailAddress() {
        return config.contactEmailAddress();
    }

    public int getStoreID() {
        return config.storeID();
    }
}
