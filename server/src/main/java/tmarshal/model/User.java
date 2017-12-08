package tmarshal.model;

import com.google.gdata.model.gd.StructuredPostalAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by scoan04 on 11/27/2017.
 */
@Component
public class User {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    Integer key;
    String userName;
    String first;
    String last;
    String password;
    String email;
    StructuredPostalAddress postalAddress;

    public User (Integer key, String userName) {
        this.key = key;
        this.userName = userName;
        this.email = userName + "@kamasoft.org";
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StructuredPostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(StructuredPostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return key.equals(user.key);

    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
