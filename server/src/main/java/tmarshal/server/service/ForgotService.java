package tmarshal.server.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class ForgotService {
    final static String CONFIGURATION_ERROR_MESSAGE = "Configuration error";
    final static String SENDING_ERROR_MESSAGE = "Problem sending";

    public String sendPasswordResetEmail() {
        try {
            Mailer.sendMail("tony.tuman@gmail.com", "tournament.marshal.software@gmail.com", "Reset Password", "Click on the link below to reset your password");
        } catch (IOException e) {
            return CONFIGURATION_ERROR_MESSAGE;
        } catch (MessagingException e) {
            return SENDING_ERROR_MESSAGE;
        }
        return "Done";
    }

    public String sendForgottenUsernameEmail() {
        try {
            Mailer.sendMail("tony.tuman@gmail.com", "tournament.marshal.software@gmail.com", "Reset Password", "Your username is Blah!");
        } catch (IOException e) {
            return CONFIGURATION_ERROR_MESSAGE;
        } catch (MessagingException e) {
            return SENDING_ERROR_MESSAGE;
        }
        return "Done";
    }
}

