package rabbitmq;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

abstract public class RabbitMQProducer extends RabbitMQChannel
{
    public void sendMessage(Serializable object)
    {
        try{
            System.out.println("===Sending message==== on " + getQueueName());
            getChannel().basicPublish("", getQueueName(), null, SerializationUtils.serialize(object));
            System.out.println("===Message Sent====");
        }catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
