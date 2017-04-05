package com.itgary.pro14.activemq.demo1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息生产者
 * @author garychen
 *
 */
public class JMSProducer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 连接的用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//连接的密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的连接地址 消息总线
	private static final int SENDNUM = 10;


	public static void main(String[] args) {
		ConnectionFactory connectionFactory;//生产connect
		Connection connection = null;//连接
		Session session;//会话 接收或者发送消息的线程
		Destination destination; //消息的目的地


		MessageProducer messageProducer; //消息的生产者

		//实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

		//通过连接工厂获取连接
		try {
			connection = connectionFactory.createConnection();
			//启动连接
			connection.start();
			/**
			 * param1: 是否加消息的事物
			 * param2: 直接receive的方式
			 */
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//创建session
			destination = session.createQueue("FirstQueue1");//创建消息队列
			messageProducer = session.createProducer(destination);//创建消息生产者,参数是目的地

			sendMessage(session, messageProducer); //发送消息
			session.commit();//提交事物


		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
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


	/**
	 * 发送消息
	 * @param session
	 * @param messageProducer
	 * @throws JMSException
	 */
	public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException{
		for (int i = 0; i < JMSProducer.SENDNUM; i++) {
			TextMessage message = session.createTextMessage("activeMQ 发送的消息" + i);
			System.out.println("发送消息: " + " ActiveMQ 发送的消息" + i);
			messageProducer.send(message);

		}
	}






}
