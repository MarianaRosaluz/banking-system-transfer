package br.rosaluz.banking.system.transfer.dto.converter;

import br.rosaluz.banking.system.transfer.dto.TransferDTO;
import br.rosaluz.banking.system.transfer.model.Transfer;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class TransferDTOToTransfer implements Converter<TransferDTO, Transfer> {

    @Override
    public Transfer convert(TransferDTO transferDTO) {
        return Optional.ofNullable(transferDTO).map(transferDTOChecked -> Transfer.builder()
                .accountOrigin(transferDTOChecked.getAccountOrigin())
                .accountDestination(transferDTOChecked.getAccountDestination())
                .value(transferDTOChecked.getValue())
                .build()).orElse(null);
    }

}
