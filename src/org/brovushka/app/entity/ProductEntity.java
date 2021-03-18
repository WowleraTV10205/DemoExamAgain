package org.brovushka.app.entity;

/*
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `Cost` DECIMAL(19,4) NOT NULL,
  `Description` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  `MainImagePath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
  `IsActive` TINYINT(1) NOT NULL,
  `ManufacturerID` INT NULL,
 */

import java.util.Objects;

public class ProductEntity
{
    private int id;
    private String title;
    private double cost;
    private String description;
    private String mainImagePath;
    private boolean isActive;
    private int manufacturerID;

    public ProductEntity(int id, String title, double cost, String description, String mainImagePath, int isActive, int manufacturerID) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.description = description == null ? "" : description;
        this.mainImagePath = mainImagePath;
        this.isActive = (isActive == 1);
        this.manufacturerID = manufacturerID;
    }

    public ProductEntity(String title, double cost, String description, String mainImagePath, int isActive, int manufacturerID) {
        this(-1, title, cost, description, mainImagePath, isActive, manufacturerID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id && Double.compare(that.cost, cost) == 0 && isActive == that.isActive && manufacturerID == that.manufacturerID && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(mainImagePath, that.mainImagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cost, description, mainImagePath, isActive, manufacturerID);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", isActive=" + isActive +
                ", manufacturerID=" + manufacturerID +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainImagePath() {
        return mainImagePath;
    }

    public void setMainImagePath(String mainImagePath) {
        this.mainImagePath = mainImagePath;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }
}
