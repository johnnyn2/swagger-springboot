package com.swagger.springboot.model;

// Database entity
public class Product {
    private String id;
    private String name;
    private String description;
    private String photo;
    public Product(String id, String name, String description, String photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
    }
    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    public String getPhoto() { return this.photo; }
    public void setPhoto(String photo) { this.photo = photo; }
}
