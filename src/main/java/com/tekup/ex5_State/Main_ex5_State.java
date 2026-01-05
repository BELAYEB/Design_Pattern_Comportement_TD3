package com.tekup.ex5_State;

public class Main_ex5_State {
    public static void main(String[] args) {
        UserContext user = new UserContext("john_doe");

        user.login();   // Transition de Disconnected à Connected
        user.lock();    // Transition de Connected à Locked
        user.logout();  // Pas d'effet, car l'utilisateur est Locked
        user.login();   // Pas d'effet, car l'utilisateur est Locked
    }
}
