package br.rosaluz.banking.system.transfer.service;


import br.rosaluz.banking.system.transfer.model.Transfer;

import java.util.Optional;

public interface TransferService {

    public Transfer save(Transfer transfer);
    public  boolean transfer(Transfer transferDTO);
    public Optional<Transfer> findById(long transferId);
}
