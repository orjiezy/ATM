package com.kamapulya.ATM;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, are you new here? y/n");
        String answer;
        do {
            answer = in.next();
        } while ((!answer.equals("y")) && (!answer.equals("n")));
        LogReg lr = new LogReg(answer);



    }
}
