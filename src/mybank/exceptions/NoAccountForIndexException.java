package mybank.exceptions;

public class NoAccountForIndexException extends BaseException{
    private static final String msgDefault = "Não há contas atribuídas a este cliente com o indice dado.";

    public NoAccountForIndexException() {
        super(ExceptionCodes.NO_ACCOUNT_FOR_INDEX_EXCEPTION.getValueStr(), msgDefault);
    }
}
