package ms.dataengineer.kafka;

/**
 * Created by ms on 16.09.18.
 */
public interface Constants {
    String BOOTSTRAP_SERVERS = System.getenv("BOOTSTRAP_SERVERS");
    String ACKS = System.getenv("ACKS").equals("") ? System.getenv("ACKS") : "all";
    String RETRIES = System.getenv("RETRIES").equals("") ? System.getenv("RETRIES") : "0";
    //String BATCH_SIZE = System.getenv("BATCH_SIZE").equals("") ? System.getenv("BATCH_SIZE") : "16384";
    //String LINGER_MS = System.getenv("LINGER_MS").equals("") ? System.getenv("LINGER_MS") : "1";
    //String BUFFER_MEMORY = System.getenv("BUFFER_MEMORY").equals("") ? System.getenv("BUFFER_MEMORY") : "33554432";
    Integer MAX_NUM = System.getenv("MAX_NUM").equals("") ? Integer.parseInt(System.getenv("MAX_NUM")) : 100;
    String TOPIC = System.getenv("TOPIC").equals("") ? System.getenv("TOPIC") : "Counter";
}
