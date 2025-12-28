package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Grievance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grievanceId;

    private String title;
    private String description;
    private String priority;

    @ManyToOne
    private User complainant;

    @ManyToOne
    private GrievanceCategory grievanceCategory;

    public Grievance() {}

    // getters & setters
    public Long getGrievanceId() { return grievanceId; }
    public void setGrievanceId(Long grievanceId) { this.grievanceId = grievanceId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public User getComplainant() { return complainant; }
    public void setComplainant(User complainant) { this.complainant = complainant; }

    public GrievanceCategory getGrievanceCategory() { return grievanceCategory; }
    public void setGrievanceCategory(GrievanceCategory grievanceCategory) {
        this.grievanceCategory = grievanceCategory;
    }
}

