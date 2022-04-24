package br.rosaluz.banking.system.transfer.controller;

import br.rosaluz.banking.system.transfer.dto.TransferDTO;
import br.rosaluz.banking.system.transfer.model.Transfer;
import br.rosaluz.banking.system.transfer.service.TransferService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/transfer", produces="application/json")
@Api(value="API REST Banking System")
@RequiredArgsConstructor
public class TransferController {

    @Autowired
    private TransferService transferService;

    private final ConversionService conversionService;


    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody @Valid TransferDTO transferDTO )throws Exception {
        try {

            var transfer = conversionService.convert(transferDTO, Transfer.class);
            Boolean completed = transferService.transfer(transfer);
            if (completed) {

                return ResponseEntity.ok().build();
            } else throw new Exception("A transferencia não foi realizada");

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
