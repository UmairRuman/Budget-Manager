package com.project.budgetmanager;

public class CatalogModel {
    public static final int DAILY_CATALOG = 1;
    public static final int WEEKLY_CATALOG = 2;
    public static final int MONTHS_CATALOG = 3;

    public CatalogModel(int catalogImageResourceId, String catalogName, int catalogId, int catalogCategory, int catalogPrice) {
        this.catalogImageResourceId = catalogImageResourceId;
        this.catalogName = catalogName;
        this.catalogId = catalogId;
        this.catalogCategory = catalogCategory;
        this.catalogPrice = catalogPrice;
    }

    // catalog image resource id for dummy data
    int catalogImageResourceId;
    // catalog name will describe the catalog
     String catalogName;
     // catalog id should be specific id will work as PRIMARY_KEY
     int catalogId;
     // catalog Category means daily weekly or monthly catalog
     int catalogCategory;
     // catalog Price will describe how much user spent on it according to category
     int catalogPrice;

    public int getCatalogImageResourceId() {
        return catalogImageResourceId;
    }

    public void setCatalogImageResourceId(int catalogImageResourceId) {
        this.catalogImageResourceId = catalogImageResourceId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getCatalogCategory() {
        return catalogCategory;
    }

    public void setCatalogCategory(int catalogCategory) {
        this.catalogCategory = catalogCategory;
    }

    public int getCatalogPrice() {
        return catalogPrice;
    }

    public void setCatalogPrice(int catalogPrice) {
        this.catalogPrice = catalogPrice;
    }
}
