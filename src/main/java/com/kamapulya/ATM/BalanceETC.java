package com.kamapulya.ATM;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class BalanceETC {
    private Scanner in = new Scanner(System.in);
    void showBalance(String nickname){
        DataBaseConnection db = new DataBaseConnection();
        final String query = "SELECT cash FROM usersatm WHERE user=?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getDouble("cash"));
            }
            System.out.println("Enter 'e' to exit, 'r' for refund, 'd' for deposit and 'p' for a payment.");
            String answer = in.next();
            switch (answer){
                case "e":
                    System.exit(0);
                    break;
                case "r":
                    //refund him the fucking money
                    break;
                case "d":
                    //deposit
                    break;
                case "p":
                    //make a payment
                    break;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
