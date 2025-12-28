package com.examly.springapp.controller;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.GrievanceCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grievance-categories")
public class GrievanceCategoryController {

    private final GrievanceCategoryRepository repository;

    public GrievanceCategoryController(GrievanceCategoryRepository repository) {
        this.repository = repository;
    }

    // Day10_testAddGrievanceCategory
    @PostMapping
    public ResponseEntity<GrievanceCategory> addCategory(
            @RequestBody GrievanceCategory category) {
        return new ResponseEntity<>(repository.save(category), HttpStatus.CREATED);
    }

    // Day10_testGetAllGrievanceCategories
    @GetMapping
    public ResponseEntity<List<GrievanceCategory>> getAllCategories() {
        return ResponseEntity.ok(repository.findAll());
    }

    // Day10_testGetGrievanceCategoryById
    @GetMapping("/{id}")
    public ResponseEntity<GrievanceCategory> getCategoryById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Day10_testUpdateGrievanceCategory
    @PutMapping("/{id}")
    public ResponseEntity<GrievanceCategory> updateCategory(
            @PathVariable Long id,
            @RequestBody GrievanceCategory updated) {

        return repository.findById(id).map(cat -> {
            cat.setCategoryName(updated.getCategoryName());
            cat.setDescription(updated.getDescription());
            cat.setDepartment(updated.getDepartment());
            return ResponseEntity.ok(repository.save(cat));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Day11_testSearchGrievanceCategories
    @GetMapping("/search/{query}")
    public ResponseEntity<List<GrievanceCategory>> search(@PathVariable String query) {
        return ResponseEntity.ok(
                repository.findByCategoryNameContainingIgnoreCase(query)
        );
    }
}

