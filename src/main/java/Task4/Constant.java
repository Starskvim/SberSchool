package Task4;

public class Constant {
    public static String NOT_ANOUTH_MONEY = "Недостаточно средств на счету";
    public static String BAD_DEPOSIT_WITHDRAW_AMOUNT = "Введенная сумма не удовлетворяет условию";
    public static String BAD_PIN_CHAR = "Пин-код состоит только из цифр";
    public static String BLOCK_MESSAGE = "Терминал заблокирован на:";
    public static String BAD_PIN = "Неверный пин код";
    public static String NOT_AUTH = "Сначала необходимо ввести пин-код";

    private Constant() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
