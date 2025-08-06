package com.adithya.MAMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adithya.MAMS.entity.Asset;
import com.adithya.MAMS.repo.AssetRepo;
import com.adithya.MAMS.repo.BaseRepo;

@Service
public class AssetService {

    @Autowired
    private AssetRepo assetRepository;

    @Autowired
    private BaseRepo baseRepository;

    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = getAssetById(id);
        asset.setName(assetDetails.getName());
        asset.setSerialNumber(assetDetails.getSerialNumber());
        asset.setType(assetDetails.getType());
        asset.setCurrentBase(assetDetails.getCurrentBase());
        return assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }

    public List<Asset> getAssetsByBase(Long baseId) {
        return assetRepository.findByCurrentBaseId(baseId);
    }
}

