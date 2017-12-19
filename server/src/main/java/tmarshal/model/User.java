package tmarshal.model;

import com.google.gdata.model.gd.StructuredPostalAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import tmarshal.server.exceptions.UnauthorizedAccessException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by scoan04 on 11/27/2017.
 */
@Component
public class User implements AuthorizedEntity {
    Integer key;
    String userName;
    String fullName;
    String password;
    String email;
    PostalAddress postalAddress;
    Boolean emailVerified;
    String roles;

    public User(){
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    /* Note, this is only used for JAXB and database interactions and
       does not encrypt the password.  Use encryptPassword(password)
       instead.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void encryptPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    @Override
    public void verifyAuthority(AccessTypes ...accessTypes) throws UnauthorizedAccessException {
        SimpleGrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth.getName().equals(this.getUserName()) ||
                auth.getAuthorities().contains(ADMIN_AUTHORITY))) {
            throw new UnauthorizedAccessException();
        }
    }
}
