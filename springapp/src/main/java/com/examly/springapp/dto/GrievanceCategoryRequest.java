package com.examly.springapp.dto;

public class GrievanceCategoryRequest {
    private String categoryName;
    private String description;
    private Long departmentId; // Matches JSON in your tests

    // Constructors
    public GrievanceCategoryRequest() {}

    public GrievanceCategoryRequest(String categoryName, String description, Long departmentId) {
        this.categoryName = categoryName;
        this.description = description;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}

