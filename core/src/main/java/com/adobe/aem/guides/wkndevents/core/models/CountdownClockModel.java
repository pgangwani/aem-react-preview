package com.adobe.aem.guides.wkndevents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.Nonnull;
import javax.inject.Named;

@Model(
        adaptables = {SlingHttpServletRequest.class,Resource.class},
        adapters = { CountdownClockModel.class, ComponentExporter.class },
        resourceType = CountdownClockModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
@JsonSerialize(as = CountdownClockModel.class)
public class CountdownClockModel implements ComponentExporter{

    static final String RESOURCE_TYPE = "wknd-events/components/content/countdownclock";

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

        @ValueMapValue
        private String desktopImage;

        @ValueMapValue
        private String mowImage;

        @ValueMapValue
        private String tabletImage;

        @ValueMapValue
        private String imageAltText;

        @ValueMapValue
        private String ctaUrl;

        @ValueMapValue
        private String headline1;

        @ValueMapValue
        private String headline2;

        @ValueMapValue
        private String verticalAlignment;

        @ValueMapValue
        private String horizontalAlignment;

        @ValueMapValue
        private String headlineColor;

        @ValueMapValue
        private String targetDate;

        @ValueMapValue
        private String countdownBoxBackgroundColor;

        @ChildResource
        private TaggingModel tagging;

        public TaggingModel getCtaUrlTagging() {
        return tagging;
    }

        public String getResourceType() {
        return resourceType;
    }
        public String getPageName() {
        return "Lowes homePage";
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

        public String getDesktopImage() {
        return desktopImage;
    }

        public String getMowImage() {
        return mowImage;
    }

        public String getTabletImage() {
        return tabletImage;
    }

        public String getImageAltText() {
        return imageAltText;
    }

        public String getCtaUrl() {
        return ctaUrl;
    }

        public String getHeadline1() {
        return headline1;
    }

        public String getHeadline2() {
        return headline2;
    }

        public String getVerticalAlignment() {
        return verticalAlignment;
    }

        public String getHorizontalAlignment() {
        return horizontalAlignment;
    }

        public String getHeadlineColor() {
        return headlineColor;
    }

        public String getTargetDate() {
        return targetDate;
    }

        public String getCountdownBoxBackgroundColor() {
        return countdownBoxBackgroundColor;
    }

    @Nonnull
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }


}
