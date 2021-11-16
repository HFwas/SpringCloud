package com.hfwas.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HFwas
 * @Date 2021/11/14 19:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
