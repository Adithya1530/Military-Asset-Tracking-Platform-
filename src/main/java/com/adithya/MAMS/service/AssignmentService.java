package com.adithya.MAMS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adithya.MAMS.entity.Asset;
import com.adithya.MAMS.entity.Assignment;
import com.adithya.MAMS.entity.User;
import com.adithya.MAMS.repo.AssetRepo;
import com.adithya.MAMS.repo.AssignmentRepo;
import com.adithya.MAMS.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepo assignmentRepository;
    private final AssetRepo assetRepository;
    private final UserRepo userRepository;

    public Assignment createAssignment(Assignment assignment) {
        validateAssignmentData(assignment);
        assignment.setAssignedDate(LocalDate.now());
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with ID: " + id));
    }

    public Assignment updateAssignment(Long id, Assignment updatedAssignment) {
        Assignment existing = getAssignmentById(id);

        existing.setAssignedTo(updatedAssignment.getAssignedTo());
        existing.setQuantity(updatedAssignment.getQuantity());

        if (updatedAssignment.getAsset() != null)
            existing.setAsset(validateAsset(updatedAssignment.getAsset().getId()));

        if (updatedAssignment.getAssignedBy() != null)
            existing.setAssignedBy(validateUser(updatedAssignment.getAssignedBy().getId()));

        return assignmentRepository.save(existing);
    }

    public void deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new RuntimeException("Assignment not found with ID: " + id);
        }
        assignmentRepository.deleteById(id);
    }

    public List<Assignment> getAssignmentsByUserId(Long userId) {
        return assignmentRepository.findByAssignedById(userId);
    }

    public List<Assignment> getAssignmentsByAssetId(Long assetId) {
        return assignmentRepository.findByAssetId(assetId);
    }

    private Asset validateAsset(Long assetId) {
        return assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found with ID: " + assetId));
    }

    private User validateUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
    private void validateAssignmentData(Assignment assignment) {
        if (assignment.getAsset() == null || assignment.getAsset().getId() == null)
            throw new IllegalArgumentException("Asset is required");

        if (assignment.getAssignedBy() == null || assignment.getAssignedBy().getId() == null)
            throw new IllegalArgumentException("AssignedBy User is required");

        validateAsset(assignment.getAsset().getId());
        validateUser(assignment.getAssignedBy().getId());
    }
}

