package com.adobe.aem.guides.wkndevents.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlimPopcatItem {
    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String imageAltText;

    @ValueMapValue
    private String ctaUrl;

    @ValueMapValue
    private String title;

    @ChildResource
    private TaggingModel tagging;

    public TaggingModel getTagging() {
        return tagging;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public String getCtaUrl() {
        return ctaUrl;
    }

    public String getTitle() {
        return title;
    }
}
