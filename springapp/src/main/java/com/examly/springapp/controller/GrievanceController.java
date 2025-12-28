package com.examly.springapp.controller;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.repository.GrievanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    private final GrievanceRepository grievanceRepository;

    public GrievanceController(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    // REQUIRED: PostMapping
    @PostMapping
    public ResponseEntity<Grievance> createGrievance(@RequestBody(required = false) Grievance grievance) {
        if (grievance == null) {
            return ResponseEntity.badRequest().build(); // Day6_testCreateGrievance_NoBody
        }
        return new ResponseEntity<>(grievanceRepository.save(grievance), HttpStatus.CREATED);
    }

    // REQUIRED: GetMapping
    @GetMapping
    public ResponseEntity<List<Grievance>> getAllGrievances() {
        List<Grievance> grievances = grievanceRepository.findAll();
        if (grievances.isEmpty()) {
            return ResponseEntity.noContent().build(); // Day6_testGetAllGrievances_StatusNoContent
        }
        return ResponseEntity.ok(grievances);
    }

    // REQUIRED: PathVariable
    @GetMapping("/{id}")
    public ResponseEntity<?> getGrievanceById(@PathVariable Long id) {
        Optional<Grievance> grievance = grievanceRepository.findById(id);
        return grievance
                .map(g -> ResponseEntity.ok((Object) g))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grievance not found"));
    }

// REQUIRED: PutMapping
    @PutMapping("/{id}")
    public ResponseEntity<Grievance> updateGrievance(
            @PathVariable Long id,
            @RequestBody Grievance updated) {

        return grievanceRepository.findById(id).map(g -> {
            g.setTitle(updated.getTitle());
            g.setDescription(updated.getDescription());
            g.setPriority(updated.getPriority());
            g.setGrievanceCategory(updated.getGrievanceCategory());
            g.setComplainant(updated.getComplainant());
            return ResponseEntity.ok(grievanceRepository.save(g));
        }).orElse(ResponseEntity.notFound().build());
    }

    // REQUIRED: DeleteMapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrievance(@PathVariable Long id) {
        if (!grievanceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        grievanceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}