package com.adithya.MAMS.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adithya.MAMS.entity.Asset;
import com.adithya.MAMS.entity.Base;
import com.adithya.MAMS.entity.User;
import com.adithya.MAMS.repo.AssetRepo;
import com.adithya.MAMS.repo.BaseRepo;
import com.adithya.MAMS.repo.UserRepo;

@Service
public class BaseService {

    @Autowired
    private BaseRepo baseRepository;
    
    @Autowired
    private UserRepo userRepository ;
    
    @Autowired
    private AssetRepo assetRepository ;

    public Base createBase(Base base) {
        return baseRepository.save(base);
    }

    public List<Base> getAllBases() {
        return baseRepository.findAll();
    }

    public Base getBaseById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Base not found with id: " + id));
    }

    public Base updateBase(Long id, Base updatedBase) {
        Base existing = getBaseById(id);
        existing.setName(updatedBase.getName());
        existing.setLocation(updatedBase.getLocation());
        return baseRepository.save(existing);
    }

    public void deleteBase(Long id) {
        baseRepository.deleteById(id);
    }
    
    public List<User> getUsersForBase(Long baseId){
    	
    	return userRepository.findByBaseId(baseId) ;
    }
    
    public List<Asset> getAssetsForBase(Long baseId){
    	
    	return assetRepository.findByCurrentBaseId(baseId) ;
    }
}

