package mybank.exceptions;

public class NotEnoughMoneyException extends BaseException {
    private static final String msgDefault = "Valor indisponível.";

    public NotEnoughMoneyException() {
        super(ExceptionCodes.NOT_ENOUGH_MONEY_EXCEPTION.getValueStr(), msgDefault);
    }
}
