package com.adithya.MAMS.controller;


import com.adithya.MAMS.entity.Asset;
import com.adithya.MAMS.service.AssetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@Tag(name = "Asset Management", description = "Operations related to Asset entity")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @Operation(summary = "Create a new asset")
    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset created = assetService.createAsset(asset);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Get all assets")
    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    @Operation(summary = "Get an asset by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return ResponseEntity.ok(assetService.getAssetById(id));
    }

    @Operation(summary = "Update an asset by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails) {
        Asset updated = assetService.updateAsset(id, assetDetails);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete an asset by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all assets by base ID")
    @GetMapping("/base/{baseId}")
    public ResponseEntity<List<Asset>> getAssetsByBase(@PathVariable Long baseId) {
        return ResponseEntity.ok(assetService.getAssetsByBase(baseId));
    }
}

