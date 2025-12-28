package com.examly.springapp.service;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.GrievanceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrievanceCategoryServiceImpl implements GrievanceCategoryService {

    @Autowired
    private GrievanceCategoryRepository categoryRepository;

    @Override
    public GrievanceCategory createCategory(GrievanceCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<GrievanceCategory> getAllCategories() { return categoryRepository.findAll(); }

    @Override
    public GrievanceCategory getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public GrievanceCategory updateCategory(Long id, GrievanceCategory category) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setCategoryName(category.getCategoryName());
            existing.setDescription(category.getDescription());
            existing.setDepartment(category.getDepartment());
            return categoryRepository.save(existing);
        }).orElse(null);
    }
}
