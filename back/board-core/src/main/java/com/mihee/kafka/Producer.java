package com.mihee.kafka;

import java.io.IOException;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

    public static void main(String[] args) throws IOException {

        /**
         * 프로듀서 관련 설정
         * 자바 프로퍼티 객체를 통해 설정 내용을 정의하여 준다.
         * */
        Properties configs = new Properties();
        configs.put("bootstrap.servers", "localhost:9092");
        // 부트 스트랩의 서버 설정을 로컬 호스트의 카프카를 바라보도록 설정한다.
        // 카프카 브로커의 주소 목록은 2개 이상의 ip와 port 설정을 권장한다.
        // 한 개의 브로커에 문제가 생겨도 다른 정상 브로커에 연결되어 사용 가능하기 때문
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // key와 value를 StringSerializer를 통해 직렬화 설정을 하여 준다.
        // Serializer은 key 또는 value를 직렬화 하기 위해 사용된다.
        // key는 메시지를 보내면, 토픽의 파티션이 지정될 때 사용되는 것이다.

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);
        // 전송할 객체

        ProducerRecord record = new ProducerRecord<String, String>("click_log", "login");
        // 카프카 클라이언트에서 ProducerRecord 클래스를 제공한다.
        // ProducerRecord 인스턴스 생성시 어느 토픽에 넣을 것인지, 어떤 key와 value를 담을 것인지 설정할 수 있다.
        // 위의 코드는 click_log 토픽에 키없이 login이라는 value를 보내는 것이다.
        // 키를 설정해주는 경우에는 아래와 같이 짜주면 된다.
        // ProducerRecord record = new ProducerRecord <String, String> ("click_log", "1", "login");
        // 파라미터 개수에 따라 오버로딩되어 자동으로 인스턴스가 생성된다.
        producer.send(record);
        producer.close();
    }
}
