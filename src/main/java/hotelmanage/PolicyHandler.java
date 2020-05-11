package hotelmanage;

import hotelmanage.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCheckedOut_객실정비요청(@Payload CheckedOut checkedOut){

        if(checkedOut.isMe()){
            System.out.println("##### listener 객실정비요청 : " + checkedOut.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_객실상태변경(@Payload Reserved reserved){

        if(reserved.isMe()){
            System.out.println("##### listener 객실상태변경 : " + reserved.toJson());
        }
    }

}
