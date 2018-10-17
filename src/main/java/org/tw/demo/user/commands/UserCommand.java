package org.tw.demo.user.commands;

public class UserCommand {

    private String fullName;
    private String phone;

    public UserCommand(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public UserCommand() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }
}
