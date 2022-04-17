package Task4;

import Task4.TerminalExceptions.BadDepositAmount;
import Task4.TerminalExceptions.BadWithdrawAmount;
import Task4.TerminalExceptions.TerminalException;
import org.apache.commons.validator.routines.UrlValidator;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl() {
        this.server = new TerminalServer();
        this.pinValidator = new PinValidator();
    }

    public void isUnlocked() throws TerminalException {
        pinValidator.isUnlocked();
    }

    // https://mvnrepository.com/
    public boolean checkUrl(String input) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(input);
    }

    // Класть и снимать деньги можно только, если сумма кратна 100.
    private boolean isBadAmount(double amount) {
        return (amount % 100 != 0) || (amount <= 0);
    }

    public void authUserWithPin(String pin) throws TerminalException {
        this.pinValidator.nextPinInpserted(pin);
    }

    public double showBalance() throws TerminalException {
        pinValidator.isUnlocked();
        return server.getBalance();
    }

    public void checkDepositAmount(double amount) throws BadDepositAmount {
        if (isBadAmount(amount)) {
            throw new BadDepositAmount(Constant.BAD_DEPOSIT_WITHDRAW_AMOUNT);
        }
    }

    public void checkWithdrawAmount(double amount) throws BadWithdrawAmount {
        if (isBadAmount(amount)) {
            throw new BadWithdrawAmount(Constant.BAD_DEPOSIT_WITHDRAW_AMOUNT);
        }
    }

    public void deposit(double amount) throws TerminalException {
        pinValidator.isUnlocked();
        checkDepositAmount(amount);
        server.deposit(amount);
    }

    public void withdraw(double amount) throws TerminalException {
        pinValidator.isUnlocked();
        checkWithdrawAmount(amount);
        server.withdraw(amount);
    }
}
