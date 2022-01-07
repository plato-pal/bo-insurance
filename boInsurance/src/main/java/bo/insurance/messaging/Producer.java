package bo.insurance.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class Producer {
	
	private final static String CUSTOMER_QUEUE_NAME = "CustomerQueue";

	public static void sendMessage(CustomerMessage customerMsg) throws IOException, TimeoutException {
		
		System.out.println("Sending message...........");
        try (Connection connection =ConnectionUtils.getConnection();
        		Channel channel = connection.createChannel();){
        	
        	channel.queueDeclare(CUSTOMER_QUEUE_NAME,false,false,false,null);
        	String message = ConnectionUtils.convertItemToJsonString(customerMsg);
        	channel.basicPublish("", CUSTOMER_QUEUE_NAME, null, message.getBytes());
        	System.out.println("Message has been sent: '" + message + "'");
        	
		}
		
	}
	
	
}
