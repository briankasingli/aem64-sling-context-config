package com.sling.context.test.core.models;

import com.day.cq.wcm.api.Page;
import com.sling.context.test.core.configs.DefaultSiteConfigurationService;
import com.sling.context.test.core.configs.SiteConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class)
public class SiteConfigurationModel {

    @Inject
    private Resource resource;

    @ScriptVariable(name = "currentPage")
    private Page page;

    private SiteConfiguration config = null;

    @OSGiService
    DefaultSiteConfigurationService defaultConfig;

    @PostConstruct
    private void init() {
        config = page.adaptTo(ConfigurationBuilder.class).as(SiteConfiguration.class);
    }

    public String getWebsiteColor() {
        return StringUtils.isNotBlank(config.websiteColor()) ? config.websiteColor() : defaultConfig.websiteColor();
    }

    public String getContactEmailAddress() {
        return StringUtils.isNotBlank(config.contactEmailAddress()) ? config.contactEmailAddress() : defaultConfig.contactEmailAddress();
    }

    public int getStoreID() {
        return config.storeID() != 0 ? config.storeID() : defaultConfig.storeID();
    }
}
