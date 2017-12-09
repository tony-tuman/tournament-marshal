package tmarshal.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tmarshal.server.service.Mailer;

@SpringBootApplication
public class TournamentMarshalServer {

    public static void main(String[] args) {
        Mailer.sendMail("tournament.marshal.software@gmail.com", "tony.tuman@gmail.com", "Test Email", "This is a test email sent from the Tournament Marshal Software");
        SpringApplication.run(TournamentMarshalServer.class, args);
    }

}