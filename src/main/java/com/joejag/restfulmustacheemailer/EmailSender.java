package com.joejag.restfulmustacheemailer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    public static void send(String recipient, String subject, String body) {
        Session session = Session.getInstance(getProperties());

        try {
            Message message = createMessage(session, recipient, subject, body);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static Message createMessage(Session session, String recipient, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("An example <thatsme@yourhost.com>"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(body, "utf-8", "html");
        return message;
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "YOUR_SMTP_EMAIL_HOST");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.port", "25");
        return props;
    }
}
