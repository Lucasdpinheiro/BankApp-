package mybank.exceptions;

public class InvalidAmounException extends BaseException{
    private static final String msgDefault = "Operação não realizada. Valor inválido.";

    public InvalidAmounException() {
        super(ExceptionCodes.INVALID_AMOUNT_EXCEPTION.getValueStr(), msgDefault);
    }
}
