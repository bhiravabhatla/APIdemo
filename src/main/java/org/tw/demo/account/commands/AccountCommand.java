package org.tw.demo.account.commands;

public class AccountCommand {

    private String fullName;
    private String phone;
    private String email;
    private String desc;

    public AccountCommand(String fullName, String phone, String email, String desc) {

        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.desc = desc;
    }

    public AccountCommand() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDesc() {
        return desc;
    }
}
