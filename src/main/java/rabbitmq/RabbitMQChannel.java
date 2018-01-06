package rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

abstract public class RabbitMQChannel
{
    private Channel channel;

    private Connection connection;

    /**
     * Queue name
     * @return
     */
    abstract protected String getQueueName();

    /**
     *
     * @return Channel
     */
    protected Channel getChannel()
    {
        return channel;
    }

    RabbitMQChannel()
    {
        try{
            connection  = RabbitMQConnection.getConnection();
            channel     = connection.createChannel();
            declareQueue(getQueueName());
        }catch (IOException e){
            //log
        }catch (TimeoutException e){
            //log
        }
    }

    protected void declareQueue(String queueName)
    {
        try{
            getChannel().queueDeclare(this.getQueueName(), false, false, false, null);
        }catch (IOException e){
            //log
        }
    }

    /**
     *
     * @throws TimeoutException
     * @throws IOException
     */
    public void finalize() throws TimeoutException, IOException
    {
        this.channel.close();
        this.connection.close();
    }
}
