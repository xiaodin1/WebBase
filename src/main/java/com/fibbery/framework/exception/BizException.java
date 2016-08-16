package com.fibbery.framework.exception;

import com.fibbery.framework.vo.enums.ResultCodeEnum;

/**
 * 通用业务异常类
 * Created by jiangnenghua on 2016/8/16.
 */
public class BizException extends Exception {

    private ResultCodeEnum code;

    public BizException(ResultCodeEnum code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizException(ResultCodeEnum code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ResultCodeEnum code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BizException(ResultCodeEnum code) {
        super(code.getMessage());
        this.code = code;
    }


    public String getStackMsg() {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = this.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }

        return sb.toString();
    }
}
