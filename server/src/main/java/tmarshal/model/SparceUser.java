package tmarshal.model;

import tmarshal.model.User;

public class SparceUser {
    Integer key;
    String userName;
    String firstName;
    String lastName;

    public SparceUser (User user) {
        this.key = user.getKey();
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
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
}
