package com.examly.springapp.controller;

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<?> getDepartmentsPage(
        @PathVariable int pageNumber,
        @PathVariable int pageSize) {

    Page<Department> page = departmentService.getDepartmentsPage(pageNumber, pageSize);

    return ResponseEntity.ok(page);
    }


    @PostMapping
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        Department saved = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> list = departmentService.getAllDepartments();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Department not found\"}");
        }
        return ResponseEntity.ok(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @Valid @RequestBody Department department) {
        Department updated = departmentService.updateDepartment(id, department);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Department not found\"}");
        }
        return ResponseEntity.ok(updated);
    }
}

