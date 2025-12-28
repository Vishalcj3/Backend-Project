package com.examly.springapp.service;
import com.examly.springapp.model.Department;
import java.util.List;
import org.springframework.data.domain.Page;
public interface DepartmentService {
     Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Page<Department> getDepartmentsPage(int pageNumber, int pageSize);
}
