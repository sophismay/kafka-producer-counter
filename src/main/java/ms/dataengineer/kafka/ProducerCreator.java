package ms.dataengineer.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by ms on 16.09.18.
 */
public class ProducerCreator {

    public static Producer<String, String> createProducer() {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.ACKS_CONFIG, Constants.ACKS);
        props.put(ProducerConfig.RETRIES_CONFIG, Integer.parseInt(Constants.RETRIES));
        //props.put(ProducerConfig.BATCH_SIZE_CONFIG, Integer.parseInt(Constants.BATCH_SIZE));
        //props.put(ProducerConfig.LINGER_MS_CONFIG, Integer.parseInt(Constants.LINGER_MS));
        //props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, Integer.parseInt(Constants.BUFFER_MEMORY));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        System.out.println("Bootstrap Servers : " + Constants.BOOTSTRAP_SERVERS);
        System.out.println("BS : " + System.getenv("BOOTSTRAP_SERVERS"));
        return new KafkaProducer<String, String>(props, new StringSerializer(), new StringSerializer());

    }

}
