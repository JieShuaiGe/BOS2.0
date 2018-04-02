package com.itheima.activemq;

import com.itheima.utils.MailUtils;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author Vincent
 * @Description:
 * @create 2018-04-02 9:46
 */
@Component
public class ActiveEmailConsumer implements MessageListener {

 @Override
 public void onMessage(Message message) {
  MapMessage mapMessage = (MapMessage) message;
  try {
   String emailAddress = mapMessage.getString("emailAddress");
   String emailBody = mapMessage.getString("emailBody");
   MailUtils.sendMail("team7_email",emailBody,emailAddress);
   System.out.println("-------------------------email send-->"+emailBody);

  } catch (JMSException e) {
   e.printStackTrace();
  }



 }

}

