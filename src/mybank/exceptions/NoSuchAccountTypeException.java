package mybank.exceptions;

public class NoSuchAccountTypeException extends BaseException{
    private static final String msgDefault = "Tipo de conta inexistente.";

    public NoSuchAccountTypeException() {
        super(ExceptionCodes.NO_SUCH_ACCOUNT_TYPE_EXCEPTION.getValueStr(), msgDefault);
    }
}
