package com.tekup.ex5_State;

public class LockedState implements UserState{
    @Override
    public void login(UserContext user) {
        System.out.println("Cannot login. " + user.getUsername() + "'s account is locked.");
    }

    @Override
    public void logout(UserContext user) {
        System.out.println("Cannot logout. " + user.getUsername() + "'s account is locked.");
    }

    @Override
    public void lock(UserContext user) {
        System.out.println(user.getUsername() + "'s account is already locked.");
    }
}
