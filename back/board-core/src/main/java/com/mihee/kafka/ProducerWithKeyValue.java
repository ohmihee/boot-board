package com.mihee.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerWithKeyValue {

    private static String TOPIC_NAME = "test";
    private static String BOOTSTRAP_SERVERS = "3.36.121.82:9092";

    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        for (int index = 0; index < 10; index++) {
            String data = "This is record " + index;
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME,
                    Integer.toString(index), data);
            try {
                producer.send(record);
                System.out.println("Send to " + TOPIC_NAME + " | data : " + data);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
