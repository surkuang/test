package com.fpi.test.general;

import com.alibaba.fastjson.JSONObject;
import com.fpi.test.general.NotResponseBody;
import com.fpi.test.general.ResultCode;
import com.fpi.test.general.ResultModel;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @description: 全局异常处理，全局返回值封装
 *
 * @author ZengShuo
 * @since 2020/12/24
 */
@RestControllerAdvice
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultModel handleMethodArgumentException(MethodArgumentNotValidException e) {
        return new ResultModel<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), e.getBindingResult().getFieldError().getDefaultMessage());
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !(methodParameter.getParameterType().equals(ResultModel.class) || methodParameter.hasMethodAnnotation(NotResponseBody.class));
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof String){
            return JSONObject.toJSONString(ResultModel.success(o));
        }
        return ResultModel.success(o);
    }
}
