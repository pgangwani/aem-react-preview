package com.adobe.aem.guides.wkndevents.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TaggingModel {

    @Inject
    private String pageSpot;

    @Inject
    private String pageCategory;

    @Inject
    private String promoType;

    @Inject
    private String spotDescription;

    public String getPageSpot() {
        return pageSpot;
    }

    public String getPageCategory() {
        return pageCategory;
    }

    public String getPromoType() {
        return promoType;
    }

    public String getSpotDescription() {
        return spotDescription;
    }

}
