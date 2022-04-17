package Task4;

public class Constant {
    public static final String NOT_ANOUTH_MONEY = "Недостаточно средств на счету";
    public static final String BAD_DEPOSIT_WITHDRAW_AMOUNT = "Введенная сумма не удовлетворяет условию";
    public static final String BAD_PIN_CHAR = "Пин-код состоит только из цифр";
    public static final String BLOCK_MESSAGE = "Терминал заблокирован на:";
    public static final String BAD_PIN = "Неверный пин код";
    public static final String NOT_AUTH = "Сначала необходимо ввести пин-код";
    public static final Integer MAX_ATTEMPTS_COUNT = 3;
    public static final Integer BLOCK_TIME_SEC = 10;
    public static final String VALIDE_PIN = "0123";

    private Constant() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
