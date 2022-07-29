package mybank.exceptions;

public class SameNameException extends BaseException {
    private static final String msgDefault = "Nome igual ao anterior.";

    public SameNameException() {
        super(ExceptionCodes.SAME_NAME_EXCEPTION.getValueStr(), msgDefault);
    }
}
