package rabbitmq;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

abstract public class RabbitMQConsumer extends RabbitMQChannel implements Runnable, Consumer
{

    /**
     * @param s
     * @param envelope
     * @param basicProperties
     * @param body
     * @throws IOException
     */
    abstract public void handleDelivery(String s,
                                        Envelope envelope,
                                        AMQP.BasicProperties basicProperties,
                                        byte[] body) throws IOException;

    public void run()
    {
        try{
            //don't forget this!!
            getChannel().basicConsume(getQueueName(),false,this );
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
    /**
     * Called when consumer is registered.
     */
    public void handleConsumeOk(String consumerTag)
    {
        System.out.println("Consumer "+consumerTag +" registered");
    }
    public void handleCancel(String consumerTag) {}
    public void handleCancelOk(String consumerTag) {}
    public void handleRecoverOk(String consumerTag) {}

}
