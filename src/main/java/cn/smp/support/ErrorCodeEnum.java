package cn.smp.support;

import lombok.Getter;

/**
 * 异常枚举
 */
public enum ErrorCodeEnum {

    ERR_SYS_PARAM(1000, "系统异常"),
    ERR_CHECK_PARAM(1010, "参数校验失败"),
    ERR_MISS_PARAM(1011, "参数缺失");
    @Getter
    private int errorCode;
    @Getter
    private String errorDesc;

    ErrorCodeEnum(int errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public static String getDesc(int errorCode) {
        for (ErrorCodeEnum bussErrorCode : ErrorCodeEnum.values()) {
            if (bussErrorCode.getErrorCode() == errorCode) {
                return bussErrorCode.errorDesc;
            }
        }
        return errorCode + "";
    }
}
