package common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by admin on 27.02.2017.
 */
public class UsefulFunc {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UsefulFunc.class);

    public static String appRoute = "/todolist";

    private static String username = "kiberha4@gmail.com";
    private static  String password = "proffi99@";

    public static boolean sendEmail = false;


    public static  void sendMail(String email, String subject, String text) {
        if (email==null||subject==null||text==null) {
            return;
        }
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            logger.error("The mail was send");
        } catch (MessagingException e) {
            logger.error("some wrong with mailer",e);
            throw new RuntimeException(e);
        }
    }
}
