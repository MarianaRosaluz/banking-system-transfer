package br.rosaluz.banking.system.transfer.producer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferMessageDTO {

    private long id;
    private Long accountOrigin;
    private Long accountDestination;
    private Double value;
    private String type;

}
