package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public Page<Department> getDepartmentsPage(int pageNumber, int pageSize) {
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("departmentName").ascending());
    return departmentRepository.findAll(pageRequest);
    
    }        

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        return departmentRepository.findById(id).map(existing -> {
            existing.setDepartmentName(department.getDepartmentName());
            existing.setContactEmail(department.getContactEmail());
            existing.setContactPhone(department.getContactPhone());
            return departmentRepository.save(existing);
        }).orElse(null);
    }
}

