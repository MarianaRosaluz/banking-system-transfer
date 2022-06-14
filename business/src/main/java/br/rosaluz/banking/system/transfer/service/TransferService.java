package br.rosaluz.banking.system.transfer.service;


import br.rosaluz.banking.system.transfer.model.Transfer;

import java.util.Optional;

public interface TransferService {

    Transfer save(Transfer transfer);
    void  transfer(Transfer transferDTO);
     Optional<Transfer> findById(long transferId);
     void makeTransfer(Transfer transfer);
}
