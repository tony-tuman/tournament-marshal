package tmarshal.model;

import tmarshal.model.User;

public class SparseUser {
    Integer key;
    String userName;
    String fullName;

    public SparseUser (User user) {
        this.key = user.getKey();
        this.userName = user.getUserName();
        this.fullName = user.getFullName();
    }

    public SparseUser () {
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
}
