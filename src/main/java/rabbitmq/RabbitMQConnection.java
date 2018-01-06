package rabbitmq;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQConnection
{
    public static Connection getConnection() throws TimeoutException, IOException
    {
        ConnectionFactory connectionFactory =  new ConnectionFactory();
        connectionFactory.setHost(RabbitMQConfig.host_name);

        return connectionFactory.newConnection();
    }
}

