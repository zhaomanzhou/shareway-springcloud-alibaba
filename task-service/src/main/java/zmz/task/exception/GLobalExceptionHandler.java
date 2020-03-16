package zmz.task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import response.CommonResponse;
import response.error.BusinessException;

/**
 * @author zhaomanzhou
 */

@ControllerAdvice
@Slf4j
public class GLobalExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public CommonResponse<BusinessException> BusinessExceptionHandler(BusinessException e) {
        log.info("Business Exception ", e);
        return CommonResponse.error(e.getErrorCode(), e.getErrorMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse<Exception> unknownExceptionHandler(Exception e)
    {
        log.info("Unknown Exception", e);
        return CommonResponse.error(5000, "未知错误");
    }

}
