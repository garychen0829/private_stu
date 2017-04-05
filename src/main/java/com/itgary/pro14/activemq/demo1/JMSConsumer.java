package com.itgary.pro14.activemq.demo1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息的消费者
 * @author garychen
 *
 */
public class JMSConsumer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 连接的用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//连接的密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的连接地址 消息总线

	public static void main(String[] args) {
		ConnectionFactory connectionFactory;//生产connect
		Connection connection = null;//连接
		Session session;//会话 接收或者发送消息的线程
		Destination destination; //消息的目的地

		MessageConsumer messageConsumer; //消息的消费者


		//实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();//创建连接
			//启动连接
			connection.start();

			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

			destination = session.createQueue("FirstQueue1");//创建连接的消息队列
			messageConsumer = session.createConsumer(destination);//创建消息消费者

			while (true) {
				TextMessage txt = (TextMessage)messageConsumer.receive(10000);
				if (null != txt) {
					System.out.println("收到消息"+ txt.getText());
				}else{
					break;
				}
			}

		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			if (null != connection) {
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
