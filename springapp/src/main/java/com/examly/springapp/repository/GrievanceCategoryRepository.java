package com.examly.springapp.repository;

import com.examly.springapp.model.GrievanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface GrievanceCategoryRepository extends JpaRepository<GrievanceCategory, Long> {
    List<GrievanceCategory> findByCategoryNameContainingIgnoreCase(String keyword);
}
