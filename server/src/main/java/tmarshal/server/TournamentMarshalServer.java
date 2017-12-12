package tmarshal.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tmarshal.server.service.Mailer;

import java.util.Arrays;

@SpringBootApplication
public class TournamentMarshalServer {

    public static void main(String[] args) {
        SpringApplication.run(TournamentMarshalServer.class, args);
    }
}