/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.sling.context.test.core.models;

import com.day.cq.wcm.api.Page;
import com.sling.context.test.core.configs.SiteConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables= SlingHttpServletRequest.class)
public class SiteConfigurationModel {

    @Inject
    private Resource resource;

    @ScriptVariable(name="currentPage")
    private Page page;

    private SiteConfiguration config = null;

    @PostConstruct
    private void init() {
        config = page.adaptTo(ConfigurationBuilder.class).as(SiteConfiguration.class);
    }

    public String getWebsiteColor() {
        return config.websiteColor();
    }

    public String getContactEmailAdress() {
        return config.contactEmailAdress();
    }

    public int getStoreID() {
        return config.storeID();
    }
}
