package cn.smp.support;

import cn.smp.framework.exceptions.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import static cn.smp.support.ErrorCodeEnum.ERR_CHECK_PARAM;
import static cn.smp.support.ErrorCodeEnum.ERR_MISS_PARAM;
import static cn.smp.support.ErrorCodeEnum.ERR_SYS_PARAM;

@ControllerAdvice
@Slf4j
@Component
public class ErrorHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleBindException(BindException ex) {
        log.error(ex.getMessage(), ex);
        return Result.error(ERR_CHECK_PARAM.getErrorCode(), ex.getFieldError()
                .getDefaultMessage());
    }

    @ExceptionHandler(BizException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleBindException(BizException ex) {
        log.error(ex.getMessage(), ex);
        return Result.error(ex);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleAllException(Throwable ex, HttpServletRequest req, HttpServletResponse res) {
        log.error(ex.getMessage(), ex);
        return Result.error(ERR_SYS_PARAM.getErrorCode(), ERR_SYS_PARAM.getErrorDesc());
    }

    /**
     * 参数验证、绑定异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleValidateException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        return Result.error(ERR_CHECK_PARAM.getErrorCode(),ex.getBindingResult()
                .getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleMissingParamsException(MissingServletRequestParameterException ex) {
        log.error(ex.getMessage(), ex);
        return Result.error(ERR_MISS_PARAM.getErrorCode(), "缺失参数:" + ex.getParameterName());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        return Result.error(ERR_CHECK_PARAM.getErrorCode(), ex.getConstraintViolations().iterator().next().getMessage());
    }
}
