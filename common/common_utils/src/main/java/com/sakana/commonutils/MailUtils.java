package com.sakana.commonutils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 用于发送短信
 * @author YU Chenxi
 * @since 2023/10/11 21:35
 */
public class MailUtils {
    static final String username = "xxxxxx@gmail.com"; //Use your email
    static final String password = "xxxxxxxxxxxx"; //Use your security code

    public static boolean sendMail(String mailAddress, String title, String context) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS


        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    //InternetAddress.parse("to_username_a@gmail.com, to_username_b@163.com")
                    InternetAddress.parse(mailAddress)
            );
            message.setSubject(title);
            message.setText(context);

            Transport.send(message);

//            System.out.println("发送成功");

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
