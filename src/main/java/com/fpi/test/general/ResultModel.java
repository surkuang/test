package com.fpi.test.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class ResultModel<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> ResultModel<T> success(T data){
        return new ResultModel<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResultModel<T> failed(T data){
       return new ResultModel<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }

}
