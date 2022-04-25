package br.rosaluz.banking.system.transfer.dto;

import br.rosaluz.banking.system.transfer.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {

    public String accountOrigin;
    public String accountDestination;
    public Double value;

}
