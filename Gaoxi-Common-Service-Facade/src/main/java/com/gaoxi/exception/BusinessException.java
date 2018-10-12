package com.gaoxi.exception;

/**
 * Created by Administrator on 2018/10/7.
 */
public class BusinessException extends RuntimeException {

    /**
     * 业务异常
     */
    private static final long serialVersionUID = 6191445603914179692L;

    private String errorCode;

    private String errorMessage;

    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
