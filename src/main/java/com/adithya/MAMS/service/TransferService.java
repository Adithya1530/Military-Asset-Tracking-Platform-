package com.adithya.MAMS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adithya.MAMS.entity.Transfer;
import com.adithya.MAMS.repo.TransferRepo;

@Service
public class TransferService {
	
	@Autowired
	private TransferRepo transferRepository ;
	
	public Transfer createTransfer(Transfer transfer) {
        transfer.setTransferDate(LocalDate.now());
        return transferRepository.save(transfer);
    }

    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    public Transfer getTransferById(Long id) {
        return transferRepository.findById(id).orElseThrow(() -> new RuntimeException("Transfer not found"));
    }

    public void deleteTransfer(Long id) {
        transferRepository.deleteById(id);
    }

    public List<Transfer> getTransfersByFromBase(Long baseId) {
        return transferRepository.findByFromBaseId(baseId);
    }

    public List<Transfer> getTransfersByToBase(Long baseId) {
        return transferRepository.findByToBaseId(baseId);
    }

}
