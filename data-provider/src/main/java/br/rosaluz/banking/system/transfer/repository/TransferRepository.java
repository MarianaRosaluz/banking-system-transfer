package br.rosaluz.banking.system.transfer.repository;

import br.rosaluz.banking.system.transfer.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
