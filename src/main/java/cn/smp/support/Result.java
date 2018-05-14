package cn.smp.support;

import cn.smp.framework.exceptions.BizException;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private T data;  //获取调用返回值

    private int errorCode; //获取错误码

    private String errorMsg;

    private boolean success = false;

    public Result() {
    }

    public Result(T result) {
        this.data = result;
    }

    public Result(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static Result ok() {
        Result result = new Result(0, "success");
        result.setSuccess(true);
        result.data = null;
        return result;
    }

    public static Result ok(Object data) {
        Result result = new Result(0, "success");
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result error(BizException ex) {
        Result result = new Result(ex.getCode(), ex.getMsg());
        result.setSuccess(false);
        return result;
    }

    public static Result error(int errorCode, String errorMsg) {
        Result result = new Result(errorCode, errorMsg);
        result.setSuccess(false);
        return result;
    }
}
