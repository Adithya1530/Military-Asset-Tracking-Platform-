package com.adithya.MAMS.controller;

import com.adithya.MAMS.entity.Purchase;
import com.adithya.MAMS.service.PurchaseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@Tag(name = "Purchase Controller", description = "APIs for managing purchases of assets for bases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Create a new purchase")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Purchase created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        Purchase created = purchaseService.createPurchase(purchase);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all purchases")
    @ApiResponse(responseCode = "200", description = "List of all purchases")
    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @Operation(summary = "Get a purchase by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Purchase found"),
        @ApiResponse(responseCode = "404", description = "Purchase not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @Operation(summary = "Delete a purchase by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Purchase deleted"),
        @ApiResponse(responseCode = "404", description = "Purchase not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get purchases for a specific base by Base ID")
    @ApiResponse(responseCode = "200", description = "List of purchases for a base")
    @GetMapping("/base/{baseId}")
    public ResponseEntity<List<Purchase>> getPurchasesByBase(@PathVariable Long baseId) {
        return ResponseEntity.ok(purchaseService.getPurchasesByBase(baseId));
    }
}

