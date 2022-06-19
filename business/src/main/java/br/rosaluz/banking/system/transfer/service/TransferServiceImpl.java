package br.rosaluz.banking.system.transfer.service;

import br.rosaluz.banking.system.transfer.exception.AccountNotFoundException;
import br.rosaluz.banking.system.transfer.exception.TransferNotCompletedExeption;
import br.rosaluz.banking.system.transfer.feign.dto.AccountDTO;
import br.rosaluz.banking.system.transfer.feign.AccountFeignClient;
import br.rosaluz.banking.system.transfer.feign.dto.BalanceDTO;
import br.rosaluz.banking.system.transfer.model.Transfer;
import br.rosaluz.banking.system.transfer.producer.TransferProducer;
import br.rosaluz.banking.system.transfer.repository.TransferRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{


    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransferProducer transferProducer;

    @Autowired
    private AccountFeignClient accountFeignClient;


    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public void transfer(Transfer transfer){
//        makeTransfer(transfer);
        transferProducer.send(transfer);
        save(transfer);
    }


    @Override
    public Transfer save(Transfer transfer){
        return  transferRepository.save(transfer);
    }

    @Override
    public Optional<Transfer> findById(long transferId){
        return transferRepository.findById(transferId);
    }

    @Override
    public void makeTransfer(Transfer transfer) {

       var accountOrigin = getAccount(transfer.getAccountOrigin());
        var accountDestination = getAccount(transfer.getAccountDestination());

      makeDecreaseBalance(
                BalanceDTO.builder()
                .accountNumber(transfer.getAccountOrigin())
                .amount(transfer.getValue()).build());
        makeIncreaseBalance(BalanceDTO.builder()
                .accountNumber(transfer.getAccountDestination())
                .amount(transfer.getValue()).build());
    }
    private AccountDTO getAccount(String accountNumber){

        ResponseEntity<AccountDTO> accountResponseEntity = accountFeignClient.getAccount(accountNumber);
        if (accountResponseEntity.getStatusCodeValue() != 200)
        {
            throw new AccountNotFoundException("Account not Found", "accountNumber");
        }
        return accountResponseEntity.getBody();
    }

    private void  makeDecreaseBalance(BalanceDTO balanceDTO){

        ResponseEntity<?> responseEntity = accountFeignClient.decreaseBalance(balanceDTO);

        if (responseEntity.getStatusCodeValue() != 200)
        {
            throw new TransferNotCompletedExeption("Transfer cannot be  completed", "transfer");
        }
    }
    private void  makeIncreaseBalance(BalanceDTO balanceDTO){

        ResponseEntity<?> responseEntity = accountFeignClient.increaseBalance(balanceDTO);

        if (responseEntity.getStatusCodeValue() != 200)
        {
            throw new TransferNotCompletedExeption("Transfer cannot be  completed", "transfer");
        }
    }

}
