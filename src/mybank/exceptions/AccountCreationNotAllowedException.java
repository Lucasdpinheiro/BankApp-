package mybank.exceptions;

public class AccountCreationNotAllowedException extends BaseException {
    private static final String msgDefault = "A criação de conta-poupança por pessoa jurídica não é permitida.";

    public AccountCreationNotAllowedException() {
        super(ExceptionCodes.AUTHENTICATION_FAILED_EXCEPTION.getValueStr(), msgDefault);
    }
}
