package mybank.exceptions;

public enum ExceptionCodes {
    BASE_EXCEPTION(0),
    AUTHENTICATION_FAILED_EXCEPTION(1),
    REDUNDANT_OPERATION_EXCEPTION(2),
    SAME_PASSWORD_EXCEPTION(3),
    SAME_EMAIL_EXCEPTION(4),
    SAME_NAME_EXCEPTION(5),
    INACTIVE_ACCOUNT_EXCEPTION(6),
    LOGGED_OUT_EXCEPTION(7),
    NO_SUCH_ACCOUNT_TYPE_EXCEPTION(8),
    NO_SUCH_CLIENT_TYPE_EXCEPTION(9),
    INVALID_AMOUNT_EXCEPTION(10),
    NOT_ENOUGH_MONEY_EXCEPTION(11),
    ACCOUNT_CREATION_NOT_ALLOWED(12),
    NO_ACCOUNT_FOR_INDEX_EXCEPTION(13);

    private final int value;

    private ExceptionCodes(int value) {
        this.value = value;
    }

    public String getValueStr() {
        return Integer.toString(this.value);
    }
}
