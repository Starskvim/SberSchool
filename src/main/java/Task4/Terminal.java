package Task4;

import Task4.TerminalExceptions.TerminalException;

public interface Terminal {
    void authUserWithPin(String pin) throws TerminalException;
    double showBalance() throws TerminalException;
    void withdraw(double amount) throws TerminalException;
    void deposit(double amount) throws TerminalException;
    void isUnlocked() throws TerminalException;
    boolean checkUrl(String input);
}
