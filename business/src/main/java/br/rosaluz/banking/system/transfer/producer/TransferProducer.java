package br.rosaluz.banking.system.transfer.producer;

import br.rosaluz.banking.system.transfer.model.Transfer;
import br.rosaluz.banking.system.transfer.producer.dto.TransferMessageDTO;
import br.rosaluz.banking.system.transfer.producer.dto.converter.TransferToTransferMessageDTO;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransferProducer{

    private static final Logger logger = LoggerFactory.getLogger(TransferProducer.class);
    private final String topic;
    private final KafkaTemplate<String, TransferMessageDTO> kafkaTemplate;

    public TransferProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, TransferMessageDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(Transfer transfer){
        var transferMessageDTO = TransferToTransferMessageDTO.convert(transfer);
        kafkaTemplate.send(topic, transferMessageDTO).addCallback(
                success -> logger.info("Messagem send" + success.getProducerRecord().value()),
                failure -> logger.info("Message failure" + failure.getMessage())
        );
    }
}
