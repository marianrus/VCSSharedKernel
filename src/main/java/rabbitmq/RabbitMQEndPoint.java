package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class RabbitMQEndPoint
{
    //host name should be docker container name
//    final private String hostName = "rabbitmq";
    final private String hostName = "localhost";

    protected Channel channel;

    protected Connection connection;

    protected String queue_name;

    public RabbitMQEndPoint(String queue_name) throws Exception
    {
        this.queue_name = queue_name;

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost(this.hostName);

        this.connection = connectionFactory.newConnection();

        //create channel
        this.channel = connection.createChannel();

        this.channel.queueDeclare(queue_name, false, false, false, null);
    }

    public void close  () throws TimeoutException, IOException
    {
        this.channel.close();
        this.connection.close();
    }
}
