package br.rosaluz.banking.system.transfer.service;

import br.rosaluz.banking.system.transfer.model.Transfer;
import br.rosaluz.banking.system.transfer.producer.TransferProducer;
import br.rosaluz.banking.system.transfer.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{


    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransferProducer transferProducer;


    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public  boolean transfer(Transfer transfer){
        transferProducer.send(transfer);
        save(transfer);
        return  true;
    }

    @Override
    public Transfer save(Transfer transfer){
        return  transferRepository.save(transfer);
    }

    @Override
    public Optional<Transfer> findById(long transferId){
        return transferRepository.findById(transferId);
    }

}
