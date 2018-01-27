package rabbitmq.producers;

import rabbitmq.RabbitMQProducer;
import rabbitmq.RabbitMQQueues;
import rabbitmq.envelope.RepositoryNewEnvelope;

public class RepositoryNewProducer extends RabbitMQProducer
{
    public String getQueueName()
    {
        return RabbitMQQueues.REPOSITORY_NEW_QUEUE;
    }

    public static void sendMessage(String s)
    {
        new RepositoryNewProducer()
                .sendMessage(RepositoryNewEnvelope.createFromString(s));
    }
}
