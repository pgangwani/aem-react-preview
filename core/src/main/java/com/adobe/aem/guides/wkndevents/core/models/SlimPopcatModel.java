package com.adobe.aem.guides.wkndevents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Model(
        adaptables = {SlingHttpServletRequest.class,Resource.class},
        adapters = { SlimPopcatModel.class, ComponentExporter.class },
        resourceType = { SlimPopcatModel.RESOURCE_TYPE },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")
@JsonSerialize(as = SlimPopcatModel.class)

public class SlimPopcatModel implements ComponentExporter {

    static final String RESOURCE_TYPE = "wknd-events/components/content/slimpopcat";

    @ValueMapValue
    @Named("sling:resourceType")
    private String resourceType;

    @ValueMapValue
    private String sectionHeading;

    @ValueMapValue
    private String bannerTheme;

    @ValueMapValue
    private Boolean isPng8;

    @ValueMapValue
    private Boolean fullScale;

    @ValueMapValue
    private String topPadding;

    @ValueMapValue
    private String bottomPadding;
    @ChildResource
    private List<SlimPopcatItem> products;

    public String getResourceType() {
        return resourceType;
    }

    public String getSectionHeading() {
        return sectionHeading;
    }

    public String getBannerTheme() {
        return bannerTheme;
    }

    public Boolean getPng8() {
        return isPng8;
    }

    public Boolean getFullScale() {
        return fullScale;
    }

    public String getTopPadding() {
        return topPadding;
    }

    public String getBottomPadding() {
        return bottomPadding;
    }

    public List<SlimPopcatItem> getProducts() {
        return products;
    }

    @Nonnull
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}

