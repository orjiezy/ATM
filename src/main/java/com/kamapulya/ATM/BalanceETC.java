package com.kamapulya.ATM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class BalanceETC {
    private Scanner in = new Scanner(System.in);
    private double cash;
    void showBalance(String nickname){
        DataBaseConnection db = new DataBaseConnection();
        final String query = "SELECT cash FROM usersatm WHERE user=?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cash = resultSet.getDouble("cash");
                System.out.println(cash);
            }


            System.out.println("Enter '/exit' to exit, '/refund' for refund, '/deposit' for deposit and '/payment' for a payment.");
            String answer = in.next();
            switch (answer){
                case "/exit":
                    System.exit(0);
                    break;
                case "/refund":
//                    refund him the fucking money
                    BankHelper bh = new BankHelper();
                    bh.refund(nickname, cash);
                    break;
                case "/deposit":
                    //deposit
                    break;
                case "/payment":
                    //make a payment
                    break;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
