package tmarshal.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class EmailValidationKey {
    private LocalDateTime created;
    private String url;
    private Boolean executed;

    public EmailValidationKey (){
        created = LocalDateTime.now();
        url = UUID.randomUUID().toString();
    }
}
