package zmz.task.exception;

import response.error.CommonError;

public enum BusinessErrorEnum implements CommonError
{

    UNKNOWN_ERROR(5000, "未知错误"),

    PARAMETER_VALIDATION_ERROR(10000, "参数不合法"),

    USER_NOT_EXIST(10001, "用户不存在")
    ;

    BusinessErrorEnum(int errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private int errorCode;
    private String errorMessage;

    @Override
    public int getErrorCode()
    {
        return errorCode;
    }

    @Override
    public String getErrorMessage()
    {
        return errorMessage;
    }

    @Override
    public CommonError setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
        return this;
    }
}
