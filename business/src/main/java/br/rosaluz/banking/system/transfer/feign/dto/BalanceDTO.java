package br.rosaluz.banking.system.transfer.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDTO {
    private  String accountNumber;
    private  double amount;
}
