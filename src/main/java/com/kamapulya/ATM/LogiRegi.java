package com.kamapulya.ATM;


import java.sql.*;
import java.util.Scanner;

public class LogiRegi {


    PreparedStatement preparedStatement = null;
    Scanner in = new Scanner(System.in);

    public LogiRegi(String answer){
        if(answer.equals("n")){
            login();
        }
        else{
            registration();
        }
    }

    public void login(){
        System.out.println("Enter your username, please");
        DataBaseConnection db = new DataBaseConnection();
        boolean isValid = false;

        do{
            String userDB = in.next();
            if(userDB.equals("exit"))
                System.exit(0);
            if(userDB.equals("reg")){
                registration();
                break;
            }

            final String query = "SELECT * FROM usersatm WHERE user=?";
            try {
                preparedStatement = db.getConnection().prepareStatement(query);
                preparedStatement.setString(1, userDB);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    System.out.println("You entered successful");
                    isValid = true;
                }else{
                    System.out.println("Invalid login, try again, type 'exit' to exit or type 'reg' to go to the registration");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }while(isValid == false);

    }

    public void registration(){
        System.out.println("Enter your username, please");
        String userDB = in.next();
        System.out.println("Please, enter your new password");
        String passDB = in.next();
        DataBaseConnection db = new DataBaseConnection();

        final String query = "INSERT INTO usersatm (user, password) VALUES (?, ?)";
        try {
            preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userDB);
            preparedStatement.setString(2, passDB);
            try{
                preparedStatement.execute();
            }catch (Exception e){
                System.out.println("Please, use another username, this one is busy");
                registration();
            }

            System.out.println("You registered successfully");
            //ошыбку выводить если не зарегано(можно сделать целый метод из какого-нибудь хелп класса ради этого)


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
