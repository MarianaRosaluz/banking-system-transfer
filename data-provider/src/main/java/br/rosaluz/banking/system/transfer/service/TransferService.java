package br.rosaluz.banking.system.transfer.service;


import br.rosaluz.banking.system.transfer.model.Transfer;

public interface TransferService {

    public Transfer save(Transfer transfer);
    public  boolean transfer(Transfer transferDTO);
}
