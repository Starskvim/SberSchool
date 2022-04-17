package Task4;

import Task4.TerminalExceptions.BadPinException;
import Task4.TerminalExceptions.TerminalException;
import Task4.TerminalExceptions.TerminalIsBlockedException;

import java.time.Instant;

public class PinValidator {
    private static final int MAX_ATTEMPTS_COUNT = 3;
    private static final int BLOCK_TIME_SEC = 10;

    private int currentAttempts;
    private boolean isLocked;
    private Instant lockTime;
    private boolean isAuthenticated;
    private String currentUserPin;

    public PinValidator() {
        currentAttempts = 0;
        isAuthenticated = false;
        isLocked = false;
        currentUserPin = "";
    }

    private String getPinFromProvider() {
        return "0123";
    }

    private boolean isCorrectPin(String pin) {
        return getPinFromProvider().equals(pin);
    }

    private void unblock() {
        isLocked = false;
        currentAttempts = 0;
    }

    private void checkLock() throws TerminalIsBlockedException {
        if (isLocked) {
            final long timePassed = Instant.now().getEpochSecond() - lockTime.getEpochSecond();
            if (timePassed < BLOCK_TIME_SEC)
                throw new TerminalIsBlockedException(
                        Constant.BLOCK_MESSAGE + (BLOCK_TIME_SEC - timePassed));
            else {
                unblock();
            }
        }
    }

    private void isTimeForBlock() {
        currentAttempts++;
        if (currentAttempts == MAX_ATTEMPTS_COUNT) {
            this.isLocked = true;
            lockTime = Instant.now();
        }
    }

    public void isUnlocked() throws TerminalException {
        if (!isAuthenticated) {
            throw new TerminalException(Constant.NOT_AUTH);
        }
    }

    private boolean isNumericString(String str){
        return str.chars().allMatch( Character::isDigit );
    }

    public void nextPinInpserted(String inputPin) throws TerminalException {
        if (isNumericString(inputPin)) {
            currentUserPin = inputPin;
            if (currentUserPin.length() == 4) {
                validator();
            }
        } else {
            throw new TerminalException(Constant.BAD_PIN_CHAR);
        }
    }

    private void clearPin() {
        isAuthenticated = false;
        currentUserPin = "";
    }

    private void validator() throws TerminalIsBlockedException, BadPinException {
        checkLock();
        if (isCorrectPin(currentUserPin)) {
            isAuthenticated = true;
            currentAttempts = 0;
        } else {
            clearPin();
            isTimeForBlock();
            if (!isLocked && currentAttempts !=3) throw new BadPinException(Constant.BAD_PIN);
            else throw new BadPinException(
                    Constant.BAD_PIN + "\n" + Constant.BLOCK_MESSAGE +" "+ BLOCK_TIME_SEC+" секунды");
        }
    }
}
