package com.tekup.ex5_State;

public class DisconnectedState  implements UserState {
    @Override
    public void login(UserContext user) {
        System.out.println(user.getUsername() + " is logging in.");
        user.setState(new ConnectedState());
    }

    @Override
    public void logout(UserContext user) {
        System.out.println(user.getUsername() + " is already disconnected.");
    }

    @Override
    public void lock(UserContext user) {
        System.out.println("Cannot lock. " + user.getUsername() + " is disconnected.");
    }
}
