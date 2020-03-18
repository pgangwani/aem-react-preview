package com.adobe.aem.guides.wkndevents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.Nonnull;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = {SlingHttpServletRequest.class,Resource.class},
        resourceType = { ColumnControl.RESOURCE_TYPE },
        adapters = { ColumnControl.class, ComponentExporter.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")
@JsonSerialize(as = ColumnControl.class)

public class ColumnControl implements ComponentExporter {

    static final String RESOURCE_TYPE = "wknd-events/components/content/columncontrol";

    @ValueMapValue
    private String columnsArray;

    @ValueMapValue
    @Named("sling:resourceType")
    private String resourceType;

    @ValueMapValue
    private String sectionHeading;

    @ValueMapValue
    private Boolean horizontalPadding;

    private String desktopColumnsArray;

    private String tabletColumnsArray;

    private String mobileColumnsArray;

    private String[] desktopColsArray;

    private List<Columns> desktopCols;

    public String getResourceType() {
        return resourceType;
    }

    @JsonIgnore
    public String getColumnsArray() {
        return columnsArray;
    }

    public String getSectionHeading() {
        return sectionHeading;
    }

    public Boolean getHorizontalPadding() {
        return horizontalPadding;
    }

    public String getDesktopColumnsArray() {
        if(columnsArray != null) {
            desktopColumnsArray = columnsArray.split(":")[0];
        }
        return desktopColumnsArray;
    }

    public String getTabletColumnsArray() {
        if(columnsArray != null) {
            tabletColumnsArray = columnsArray.split(":")[1];
        }
        return tabletColumnsArray;
    }

    public String getMobileColumnsArray() {
        if(columnsArray != null) {
            mobileColumnsArray = columnsArray.split(":")[2];
        }
        return mobileColumnsArray;
    }

    private List<Columns> setVals(String[] colVals) {
        List<Columns> desktopCols = new ArrayList<>();
        int colSpan;
        int i = 0;
        for(String s : colVals){
            Columns item = new Columns();
            colSpan = Integer.parseInt(s);
            switch (colSpan) {
                case 2:
                    item.setGridClass("grid-16");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
                case 3:
                    item.setGridClass("grid-25");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
                case 4:
                    item.setGridClass("grid-33");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
                case 6:
                    item.setGridClass("grid-50");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
                case 8:
                    item.setGridClass("grid-66");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
                case 9:
                    item.setGridClass("grid-75");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
                case 12:
                    item.setGridClass("grid-100");
                    item.setCount(i);
                    desktopCols.add(item);
                    break;
            }
            i++;
        }
        return desktopCols;
    }

    @JsonIgnore
    public String[] getDesktopColsArray() {
        if(columnsArray != null) {
            desktopColsArray = desktopColumnsArray.split(",");
        }
        return desktopColsArray;
    }

    @JsonIgnore
    public List<Columns> getDesktopCols() {
        if(columnsArray != null) {
            desktopCols = new ArrayList<>();
            desktopCols = setVals(desktopColsArray);
        }
        return desktopCols;
    }

    @Nonnull
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
