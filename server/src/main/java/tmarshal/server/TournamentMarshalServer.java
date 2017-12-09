package tmarshal.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tmarshal.server.service.Mailer;

@SpringBootApplication
public class TournamentMarshalServer {

    public static void main(String[] args) {
        SpringApplication.run(TournamentMarshalServer.class, args);
    }

}