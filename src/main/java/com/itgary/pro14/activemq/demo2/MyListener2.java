package com.itgary.pro14.activemq.demo2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听-订阅者1
 * @author garychen
 *
 */
public class MyListener2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		try {
			System.out.println("订阅者 1 收到的消息: " + ((TextMessage)message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
