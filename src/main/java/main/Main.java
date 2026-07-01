package main;

import form.LoginForm;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                new LoginForm().setVisible(true);

            }
        });
    }
}