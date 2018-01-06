package rabbitmq;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

abstract public class RabbitMQProducer extends RabbitMQChannel
{
    public void sendMessage(Serializable object) throws Exception
    {
        System.out.println("===Sending message====");
        getChannel().basicPublish("", getQueueName(), null, SerializationUtils.serialize(object));
    }
}
