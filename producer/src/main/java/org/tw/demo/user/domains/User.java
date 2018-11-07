package org.tw.demo.user.domains;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String userID;
    private String fullName;
    private String phone;

    public User() {
    }

    public User(String userID, String fullName, String phone) {

        super();
        this.userID = userID;
        this.fullName = fullName;
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }
}
