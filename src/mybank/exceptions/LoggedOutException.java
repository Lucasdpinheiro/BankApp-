package mybank.exceptions;

public class LoggedOutException extends BaseException {
    private static final String msgDefault = "Operação não realizada: Conta desconectada.";

    public LoggedOutException() {
        super(ExceptionCodes.LOGGED_OUT_EXCEPTION.getValueStr(), msgDefault);
    }
}
