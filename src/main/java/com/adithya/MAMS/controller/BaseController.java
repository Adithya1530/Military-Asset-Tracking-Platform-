package com.adithya.MAMS.controller;


import com.adithya.MAMS.entity.Base;
import com.adithya.MAMS.entity.User;
import com.adithya.MAMS.entity.Asset;
import com.adithya.MAMS.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bases")
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @Operation(summary = "Create a new base")
    @ApiResponse(responseCode = "201", description = "Base created successfully")
    @PostMapping
    public ResponseEntity<Base> createBase(@RequestBody Base base) {
        Base created = baseService.createBase(base);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(summary = "Get all bases")
    @ApiResponse(responseCode = "200", description = "List of bases")
    @GetMapping
    public ResponseEntity<List<Base>> getAllBases() {
        return ResponseEntity.ok(baseService.getAllBases());
    }

    @Operation(summary = "Get base by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Base found"),
        @ApiResponse(responseCode = "404", description = "Base not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Base> getBaseById(@PathVariable Long id) {
        return ResponseEntity.ok(baseService.getBaseById(id));
    }

    @Operation(summary = "Update base details")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Base updated successfully"),
        @ApiResponse(responseCode = "404", description = "Base not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Base> updateBase(@PathVariable Long id, @RequestBody Base updatedBase) {
        return ResponseEntity.ok(baseService.updateBase(id, updatedBase));
    }

    @Operation(summary = "Delete a base by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Base deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Base not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBase(@PathVariable Long id) {
        baseService.deleteBase(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get users assigned to a base")
    @ApiResponse(responseCode = "200", description = "List of users for the base")
    @GetMapping("/{id}/users")
    public ResponseEntity<List<User>> getUsersForBase(@PathVariable Long id) {
        return ResponseEntity.ok(baseService.getUsersForBase(id));
    }

    @Operation(summary = "Get assets present in a base")
    @ApiResponse(responseCode = "200", description = "List of assets for the base")
    @GetMapping("/{id}/assets")
    public ResponseEntity<List<Asset>> getAssetsForBase(@PathVariable Long id) {
        return ResponseEntity.ok(baseService.getAssetsForBase(id));
    }
}
