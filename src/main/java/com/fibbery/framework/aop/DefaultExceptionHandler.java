package com.fibbery.framework.aop;

import com.fibbery.framework.controller.ResultInfo;
import com.fibbery.framework.exception.BizException;
import com.fibbery.framework.vo.enums.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class DefaultExceptionHandler{
    private final Logger log = LoggerFactory.getLogger(getClass());
	
    /**控制器抛出的其他异常*/
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultInfo processOtherException(Exception e , HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
		this.exception(resultInfo, e);
        return resultInfo;
    }

    /**请求发生异常(后台)*/
    protected void exception(ResultInfo resultInfo,Exception e){
        if(e==null || resultInfo==null){
            return;
        }
        this.log.error(e.getMessage(),e);
        if(e instanceof BizException){
            BizException se = (BizException)e;
//            resultInfo.setCode(se.getResultCode());
//            resultInfo.setErrorStack(se.getErrorStackTrace());
        }
        else{
            resultInfo.setCode(ResultCodeEnum.ERROR);
            resultInfo.setErrorStack(getStackMsg(e));
        }
    }

    /**获取异常的栈信息*/
    private String getStackMsg(Exception e){
        StringBuffer sb = new StringBuffer();
        if(null != e){
            StackTraceElement[] stackArray = e.getStackTrace();
            for (int i = 0; i < stackArray.length; i++){
                StackTraceElement element = stackArray[i];
                sb.append(element.toString() + "\n");
            }
        }
        return sb.toString();
    }

}
