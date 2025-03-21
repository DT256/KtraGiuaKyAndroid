// CategoryModel.java
package com.giuaky.ktragiuakyandroid.model;

import lombok.Data;

@Data
public class CategoryModel {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    private String name;
    private String description;  // Changed from double to String to match JSON
    private String images;      // Changed from image to images to match JSON

    // Add getter for image URL if needed by adapter
    public String getImageUrl() {
        return images;
    }

    public String getName() {
        return name;
    }
}