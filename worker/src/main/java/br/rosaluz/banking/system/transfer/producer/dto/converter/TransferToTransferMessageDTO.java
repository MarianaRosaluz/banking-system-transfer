package br.rosaluz.banking.system.transfer.producer.dto.converter;

import br.rosaluz.banking.system.transfer.model.Transfer;
import br.rosaluz.banking.system.transfer.producer.dto.TransferMessageDTO;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class TransferToTransferMessageDTO {

    public static TransferMessageDTO convert(Transfer transfer) {
        return Optional.ofNullable(transfer).map(transferDTOChecked -> TransferMessageDTO.builder()
                .accountOrigin(transferDTOChecked.getAccountOrigin())
                .accountDestination(transferDTOChecked.getAccountDestination())
                .value(transferDTOChecked.getValue())
                .build()).orElse(null);
    }
}
