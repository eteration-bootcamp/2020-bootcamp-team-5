package com.metindogancelik.java.codesmell;

public class ChangePreventers implements Notifiable {

    /*
        Consider that you have to do transaction multiple times.
        What to do if there is any change on transaction successful message?
    */

    public void runBefore() {
        loginBefore();

        // Do some transaction.
        System.out.println("Your transaction is successful!");

        // Do some transaction
        System.out.println("Your transaction is successful!");

        // Do some transaction
        System.out.println("Your transaction is successful!");

        logoutBefore();
    }

    public void runAfter() {
        loginAfter();

        // Do some transaction.
        System.out.println(TRANSACTION_IS_SUCCESSFUL);

        // Do some transaction
        System.out.println(TRANSACTION_IS_SUCCESSFUL);

        // Do some transaction
        System.out.println(TRANSACTION_IS_SUCCESSFUL);

        logoutAfter();
    }


    private void loginBefore() {
        // If logged in
        System.out.println("You have successfully logged in!");
    }

    private void logoutBefore() {
        // If logged out
        System.out.println("You have successfully logged out!");
    }


    private void loginAfter() {
        // If logged in
        System.out.println(LOGGED_IN_MESSAGE);
    }

    private void logoutAfter() {
        // If logged out
        System.out.println(LOGGED_OUT_MESSAGE);
    }
}
