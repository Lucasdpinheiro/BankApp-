package mybank.exceptions;

public class RedundantOperationException extends BaseException{
    private static final String msgDefault = "Esta operação não altera o status da conta.";

    public RedundantOperationException() {
        super(ExceptionCodes.REDUNDANT_OPERATION_EXCEPTION.getValueStr(), msgDefault);
    }
}
