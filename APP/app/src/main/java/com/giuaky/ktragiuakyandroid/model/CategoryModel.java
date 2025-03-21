// CategoryModel.java
package com.giuaky.ktragiuakyandroid.model;

import lombok.Data;

@Data
public class CategoryModel {
    private Long id;
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