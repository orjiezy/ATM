package com.kamapulya.ATM;

public class BankHelper {
    private ArraysETC arr = new ArraysETC();

    public void refund(double price, double paidMoney){
        if((price<=0) || (paidMoney<=0) || (paidMoney<price)){
            System.out.println("Insufficient funds/wrong request"); //I should improve this "error" in the future - for one error - one sysOut
            System.exit(1);
        }
        else{
            arr.makeArray();
            paidMoney-= price;
            double eWallet = paidMoney % 10;
            paidMoney -= eWallet;
            while (paidMoney > 0){
                paidMoney = calculate(paidMoney);
            }
            System.out.println("OK!");
            System.out.println("You have left " + eWallet + " " +  arr.getCurrency() + " on your eWallet");
        }
    }

    private double calculate(double paidMoney){
        for(int num : arr.getCash()){
            if (paidMoney - num >= 0){
                System.out.println(num);
                paidMoney -= num;
                break;
            }
        }
        return paidMoney;
    }
}
