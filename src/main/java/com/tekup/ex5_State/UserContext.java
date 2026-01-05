package com.tekup.ex5_State;

public class UserContext {
    private UserState state;
    private String username;

    public UserContext(String username) {
        this.username = username;
        this.state = new DisconnectedState(); // État initial
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public void login() {
        state.login(this);
    }

    public void logout() {
        state.logout(this);
    }

    public void lock() {
        state.lock(this);
    }

    public String getUsername() {
        return username;
    }
}
