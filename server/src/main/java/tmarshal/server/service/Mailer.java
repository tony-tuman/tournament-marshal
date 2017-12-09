package tmarshal.server.service;

import tmarshal.server.config.TournamentMarshalConfig;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
    public static void sendMail(String from, String to, String subject, String text) {
        Properties props = new Properties();
        try {
            TournamentMarshalConfig config = new TournamentMarshalConfig("C:\\Users\\Tony\\tournament-marshal.cfg");
            for (Map.Entry entry : config.getProperties("mail.*").entrySet()) {
                props.put(entry.getKey(), entry.getValue());
            }
            Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(config.getProperty("user"), config.getProperty("pwd"));
                    }
                });


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        } catch (MessagingException  | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
