package br.rosaluz.banking.system.transfer.service;

import br.rosaluz.banking.system.transfer.repository.TransferRepository;
import br.rosaluz.banking.system.transfer.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{


    @Autowired
    private TransferRepository transferRepository;


    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public  boolean transfer(Transfer transfer){
        save(transfer);
        return  true;
    }

    @Override
    public Transfer save(Transfer transfer){
        return  transferRepository.save(transfer);
    }



}