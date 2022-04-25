package br.rosaluz.banking.system.transfer.producer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferMessageDTO {

    private long id;
    private String accountOrigin;
    private String accountDestination;
    private Double value;

}
