package bo.insurance.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class PolicyMessagingService {
	public static void sendMessage(Object objMessage, String queueName) throws IOException, TimeoutException {
		
		System.out.println("Sending message...........");
        try (Connection connection =ConnectionUtils.getConnection();
        		Channel channel = connection.createChannel();){
        	
        	channel.queueDeclare(queueName,false,false,false,null);
        	String message = ConnectionUtils.convertItemToJsonString(objMessage);
        	channel.basicPublish("", queueName, null, message.getBytes());
        	System.out.println("Message has been sent: '" + message + "'");
        	
		}
		
	}
	
	
}
