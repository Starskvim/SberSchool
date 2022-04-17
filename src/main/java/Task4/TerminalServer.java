package Task4;

import Task4.TerminalExceptions.BadWithdrawAmount;

public class TerminalServer {
    private double balance;

    public TerminalServer() {
        balance= (int)(Math.random()*2000)+1;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount) throws BadWithdrawAmount {
        if(amount > balance) {
            throw new BadWithdrawAmount(Constant.NOT_ANOUTH_MONEY);
        }
        balance -= amount;
    }

}
