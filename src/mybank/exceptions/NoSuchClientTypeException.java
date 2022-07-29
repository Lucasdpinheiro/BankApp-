package mybank.exceptions;

public class NoSuchClientTypeException extends BaseException{
    private static final String msgDefault = "Tipo de cliente inexistente..";

    public NoSuchClientTypeException() {
        super(ExceptionCodes.NO_SUCH_CLIENT_TYPE_EXCEPTION.getValueStr(), msgDefault);
    }
    
}
