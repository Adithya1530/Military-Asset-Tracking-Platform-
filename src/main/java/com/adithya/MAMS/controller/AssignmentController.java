package com.adithya.MAMS.controller;

import com.adithya.MAMS.entity.Assignment;
import com.adithya.MAMS.service.AssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

	private final AssignmentService assignmentService;

	@Operation(summary = "Create a new Assignment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Assignment created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	@PostMapping
	public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
		return ResponseEntity.ok(assignmentService.createAssignment(assignment));
	}

	@Operation(summary = "Get all Assignments")
	@GetMapping
	public ResponseEntity<List<Assignment>> getAllAssignments() {
		return ResponseEntity.ok(assignmentService.getAllAssignments());
	}

	@Operation(summary = "Get Assignment by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Assignment found"),
			@ApiResponse(responseCode = "404", description = "Assignment not found") })
	@GetMapping("/{id}")
	public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
		return ResponseEntity.ok(assignmentService.getAssignmentById(id));
	}

	@Operation(summary = "Update Assignment by ID")
	@PutMapping("/{id}")
	public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id,
			@RequestBody Assignment updatedAssignment) {
		return ResponseEntity.ok(assignmentService.updateAssignment(id, updatedAssignment));
	}

	@Operation(summary = "Delete Assignment by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
		assignmentService.deleteAssignment(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Get Assignments by User ID")
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Assignment>> getAssignmentsByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(assignmentService.getAssignmentsByUserId(userId));
	}

	@Operation(summary = "Get Assignments by Asset ID")
	@GetMapping("/asset/{assetId}")
	public ResponseEntity<List<Assignment>> getAssignmentsByAssetId(@PathVariable Long assetId) {
		return ResponseEntity.ok(assignmentService.getAssignmentsByAssetId(assetId));
	}
}
