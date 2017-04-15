package com.kamapulya.ATM;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

class BankHelper {
    private ArraysETC arr = new ArraysETC();
    private double balance;
    private boolean canReturn = true;


    void refund(String user, double cash){
        balance = cash;
        if(balance<=0){
            System.out.println("Insufficient funds/wrong request"); //I should improve this "error" in the future - for one error - one sysOut
            System.exit(1);
        } else{
            arr.makeArray();
            while (canReturn)
                calculate(balance);

            System.out.println("OK!");
//            System.out.println(String.format("%(.2f", var));
//            System.out.println(String.format(new Locale("ru"), "%(.2f", var));

            String stringBalance = String.format(Locale.ENGLISH, "%(.2f", balance );
            balance = Double.parseDouble(stringBalance);
            System.out.println("You have left " + stringBalance + " " +  arr.getCurrency() + " on your eWallet");

//            Calling DB method for cleaning up database after refund
            dbRefund(user, balance);

        }
    }

    private void dbRefund(String user, double balance){

        DataBaseConnection db = new DataBaseConnection();
        String query = "UPDATE usersatm SET cash = ? WHERE user = ?";

        try {
//            Здесь ошибка в том, что нужно сделать db.getConnection().setAutoCommit(false);
//            и выполнять снятие бабла лишь тогда, когда все деньги были выданы одновременно(watch unit 12 yakov)

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, user);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    Перебирает купюры в массиве и выводит их на экран
    private boolean calculate(double paidMoney){
        int counter = 0;
        for(double num : arr.getCash()){
            balance = paidMoney;
            if (balance - num >= 0){
                System.out.println(num);
                balance -= num;
                counter++;
                break;
            }
        }
        if (counter<=0){
            canReturn = false;
        }
        return canReturn;
    }
}
