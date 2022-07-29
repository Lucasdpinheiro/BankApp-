package mybank.exceptions;

public class SamePassWordException extends BaseException{
    private static final String msgDefault = "Senha igual à anterior.";

    public SamePassWordException() {
        super(ExceptionCodes.SAME_PASSWORD_EXCEPTION.getValueStr(), msgDefault);
    }
}
