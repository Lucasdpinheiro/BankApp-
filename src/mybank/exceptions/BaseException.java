package mybank.exceptions;

public class BaseException extends Exception{
    private String msgDefault = "Erro sem resolução implementada.";
    private String code = ExceptionCodes.AUTHENTICATION_FAILED_EXCEPTION.getValueStr();

    public BaseException(String code, String message) {
        this.msgDefault = message;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msgDefault;
    }
    
}
