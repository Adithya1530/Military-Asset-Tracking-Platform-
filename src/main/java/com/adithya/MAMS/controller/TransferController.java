package com.adithya.MAMS.controller;

import com.adithya.MAMS.entity.Transfer;
import com.adithya.MAMS.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @Operation(summary = "Create a new asset transfer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Transfer created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Transfer> createTransfer(@RequestBody Transfer transfer) {
        Transfer savedTransfer = transferService.createTransfer(transfer);
        return new ResponseEntity<>(savedTransfer, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all asset transfers")
    @ApiResponse(responseCode = "200", description = "List of all transfers")
    @GetMapping
    public ResponseEntity<List<Transfer>> getAllTransfers() {
        return ResponseEntity.ok(transferService.getAllTransfers());
    }

    @Operation(summary = "Get transfer by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Transfer found"),
        @ApiResponse(responseCode = "404", description = "Transfer not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Transfer> getTransferById(@PathVariable Long id) {
        Transfer transfer = transferService.getTransferById(id);
        return ResponseEntity.ok(transfer);
    }

    @Operation(summary = "Delete a transfer by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Transfer deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Transfer not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransfer(@PathVariable Long id) {
        transferService.deleteTransfer(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get transfers by fromBase ID")
    @ApiResponse(responseCode = "200", description = "Transfers from given base")
    @GetMapping("/from-base/{baseId}")
    public ResponseEntity<List<Transfer>> getTransfersByFromBase(@PathVariable Long baseId) {
        return ResponseEntity.ok(transferService.getTransfersByFromBase(baseId));
    }

    @Operation(summary = "Get transfers by toBase ID")
    @ApiResponse(responseCode = "200", description = "Transfers to given base")
    @GetMapping("/to-base/{baseId}")
    public ResponseEntity<List<Transfer>> getTransfersByToBase(@PathVariable Long baseId) {
        return ResponseEntity.ok(transferService.getTransfersByToBase(baseId));
    }
}

