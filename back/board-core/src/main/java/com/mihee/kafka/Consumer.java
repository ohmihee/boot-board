package com.mihee.kafka;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    public static void main(String[] args) {
        // 컨슈머 사용 전에 자바 프로퍼티를 설정해준다.
        // 컨슈머 옵션 설정
        Properties configs = new Properties();
        configs.put("bootstrap.servers", "localhost:9092");
        // bootstrap.servers -> 카프카 브로커 설정
        configs.put("group.id", "click_log_group");
        // group id 지정
        // group id는 컨슈머 그룹이라고도 하며, 컨슈머 그룹은 말 그대로 컨슈머들의 묶음이라 볼 수 있다.
        configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        // key와 value에 대한 직렬화 설정

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);
        // 컨슈머 인스턴스 생성
        consumer.subscribe(Arrays.asList("click_log"));
        // click_log 토픽을 구독
        // 특정 토픽의 전체 파티션이 아닌 일부 파티션의 데이터만 가져오고 싶은 경우에는 assign() 메서드를 사용한다.
        // TopicPartition partition0 = new TopicPartition(topicName, 0);
        // TopicPartition partition1 = new TopicPartition(topicName, 1);
        // consumer.assign(Arrays.asList(partition0, partition1));

        // 데이터를 실질적으로 가져오는 부분이다.
        // 컨슈머는 poll 메서드를 통해 데이터를 가져온다.
        // poll 메서드에 설정해준 시간동안 데이터를 기다리게 된다.
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(500);
            // 500(ms) -> 0.5 초 동안 데이터를 기다린 후 이후의 코드를 실행한다.
            // 0.5 초 동안 데이터가 들어오지 않으면 빈값의 records 변수를 반환하고,
            // 데이터가 있으면, 데이터가 존재하는 records 값을 반환한다.
            // records 변수는 데이터 배치로서 레코드의 묶음 list 이다.
            // 카프카에서 실제 데이터 처리 시에는 record 단위로 이루어진다.
            // records를 for문을 들리면서 데이터를 record 단위로 처리
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
                // record.value()에서 반환된 값이 producer에 의해 생성된 데이터이다.
                // 실제 기업에서는 하둡이나 엘라스틱서치와 같은 저장소를 이용하여 데이터를 저장하여 처리한다.
            }
        }
    }
}
