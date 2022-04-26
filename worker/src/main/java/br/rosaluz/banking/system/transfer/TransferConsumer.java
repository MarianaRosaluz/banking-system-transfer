package br.rosaluz.banking.system.transfer;

import br.rosaluz.banking.system.transfer.consumer.dto.TransferConsumerMessageDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transferKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, TransferConsumerMessageDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }

}
