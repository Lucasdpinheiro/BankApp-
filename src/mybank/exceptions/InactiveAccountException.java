package mybank.exceptions;

public class InactiveAccountException extends BaseException {
    private static final String msgDefault = "A conta %s encontra-se inativa.";

    public InactiveAccountException() {
        super(ExceptionCodes.INACTIVE_ACCOUNT_EXCEPTION.getValueStr(), msgDefault);
    }

    public InactiveAccountException(String localization) {
        super(ExceptionCodes.INACTIVE_ACCOUNT_EXCEPTION.getValueStr(), String.format(msgDefault, localization));
    }
}
