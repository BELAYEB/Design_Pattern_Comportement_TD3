package com.tekup.ex5_State;

public class ConnectedState implements UserState {
    @Override
    public void login(UserContext user) {
        System.out.println(user.getUsername() + " is already connected.");
    }

    @Override
    public void logout(UserContext user) {
        System.out.println(user.getUsername() + " is logging out.");
        user.setState(new DisconnectedState());
    }

    @Override
    public void lock(UserContext user) {
        System.out.println(user.getUsername() + " is locking the account.");
        user.setState(new LockedState());
    }
}
