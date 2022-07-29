package mybank.exceptions;

public class AuthenticationFailedException extends BaseException {
    private static final String msgDefault = "Falha na autenticação: Dados incorretos.";

    public AuthenticationFailedException() {
        super(ExceptionCodes.AUTHENTICATION_FAILED_EXCEPTION.getValueStr(), msgDefault);
    }
}
