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
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    Integer key;
    String userName;
    String firstName;
    String lastName;
    String password;
    String email;
    StructuredPostalAddress postalAddress;
    Boolean emailVerified;
    String roles;

    public User (Integer key, String userName) {
        this.key = key;
        this.userName = userName;
        this.email = userName + "@kamasoft.org";
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName() + getLastName();
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
