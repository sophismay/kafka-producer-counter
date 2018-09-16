package ms.dataengineer.kafka;

/**
 * Created by ms on 16.09.18.
 */

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.errors.InterruptException;

import java.util.concurrent.ExecutionException;

public class KafkaCounterProducer {

    public static void main(String args[]) {
        runProducer();
    }

    private static void runProducer() {
        System.out.println("RUnning producer ");
        Producer<String, String> producer = ProducerCreator.createProducer();

        Callback confirmation = new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
                    System.out.println("with value : " + recordMetadata.toString());
                    System.out.println("to partition : " + recordMetadata.partition());
                }
            }
        };
        System.out.println("producer initialized : " + producer.toString());
        for(int i = 1; i <= Constants.MAX_NUM; i++) {
            System.out.println("Before sending i: " + i);
            try {
                producer.send(new ProducerRecord<String, String>(Constants.TOPIC, Integer.toString(i)), confirmation);
            } catch (Exception e) {
                System.out.println("Execution Exception in sending record");
                e.printStackTrace();
            }/* catch (InterruptException e) {
                System.out.println("Interruption Exception in sending record");
                e.printStackTrace();
            }*/

        }
        producer.close();
    }

}
