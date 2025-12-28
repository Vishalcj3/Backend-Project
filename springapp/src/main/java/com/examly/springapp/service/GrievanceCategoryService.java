package com.examly.springapp.service;

import com.examly.springapp.model.GrievanceCategory;
import java.util.List;

public interface GrievanceCategoryService {
    GrievanceCategory createCategory(GrievanceCategory category);
    List<GrievanceCategory> getAllCategories();
    GrievanceCategory getCategoryById(Long id);
    GrievanceCategory updateCategory(Long id, GrievanceCategory category);
}

