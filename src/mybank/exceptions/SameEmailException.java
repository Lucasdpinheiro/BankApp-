package mybank.exceptions;

public class SameEmailException extends BaseException {
    private static final String msgDefault = "Email igual ao anterior.";

    public SameEmailException() {
        super(ExceptionCodes.SAME_EMAIL_EXCEPTION.getValueStr(), msgDefault);
    }
    
}
