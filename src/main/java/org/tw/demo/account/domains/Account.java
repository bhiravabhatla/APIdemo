package org.tw.demo.account.domains;

import org.tw.demo.user.domains.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private String accountId;
    private String userId;
    private String email;
    private String desc;

    public Account(String accountId, String userId, String desc, String email) {
        super();
        this.accountId = accountId;
        this.userId = userId;
        this.desc = desc;
        this.email=email;
    }

    public Account(){

    }

    public String getEmail() {
        return email;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUserID() {
        return userId;
    }


    public String getDesc() {
        return desc;
    }

}
