package br.rosaluz.banking.system.transfer.consumer;

import br.rosaluz.banking.system.transfer.consumer.dto.TransferConsumerMessageDTO;
import br.rosaluz.banking.system.transfer.consumer.dto.converter.TransferConsumerMessageDTOToTransfer;
import br.rosaluz.banking.system.transfer.model.Transfer;
import br.rosaluz.banking.system.transfer.service.TransferService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransferConsumer {

    private static final Logger log = LoggerFactory.getLogger(TransferConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @Autowired
    private TransferService transferService;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transferKafkaListenerContainerFactory")
    public void listenTopicPayment(ConsumerRecord<String, TransferConsumerMessageDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }
}
