package com.kamapulya.ATM;


import java.sql.*;
import java.util.Scanner;

class LogReg {

    private PreparedStatement preparedStatement = null;
    private Scanner in = new Scanner(System.in);
    private BalanceETC BalanceETC = new BalanceETC();

    LogReg(String answer){
        if(answer.equals("n")){
            login();
        }
        else{
            registration();
        }
    }

    private void login(){
        DataBaseConnection db = new DataBaseConnection();
        boolean isValid = false;

        do{
            System.out.println("Enter your username, please");
            String userDB = in.next();
            if(userDB.equals("exit"))
                System.exit(0);
            if(userDB.equals("reg")){
                registration();
                break;  }
            System.out.println("Enter your password, please");
            String userPass = in.next();


            final String query = "SELECT * FROM usersatm WHERE user=? AND password=?";
            try {
                preparedStatement = db.getConnection().prepareStatement(query);
                preparedStatement.setString(1, userDB);
                preparedStatement.setString(2, userPass);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    System.out.println("You've entered successful");
                    isValid = true;
                    BalanceETC.showBalance(userDB);
                }else{
                    System.out.println("Invalid login or password, try again, type 'exit' to exit or type 'reg' to go to the registration");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }while(!isValid);

    }

    private void registration(){
        boolean isValid = false;
        final String query = "INSERT INTO usersatm (user, password) VALUES (?, ?)";
        System.out.println("Enter your username, please");
        String userDB = in.next();
        System.out.println("Please, enter your new password");
        String passDB = in.next();
        DataBaseConnection db = new DataBaseConnection();

        try {
            preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userDB);
            preparedStatement.setString(2, passDB);
            try{
                preparedStatement.execute();
                isValid = true;
            }catch (Exception e){
                System.out.println("Please, use another username, this one is busy");
                registration();
            }
            if (isValid) {
                System.out.println("You registered successfully");
                BalanceETC.showBalance(userDB);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                db.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
