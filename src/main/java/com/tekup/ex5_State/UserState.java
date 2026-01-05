package com.tekup.ex5_State;

public interface UserState {
    void login(UserContext user);
    void logout(UserContext user);
    void lock(UserContext user);
}
