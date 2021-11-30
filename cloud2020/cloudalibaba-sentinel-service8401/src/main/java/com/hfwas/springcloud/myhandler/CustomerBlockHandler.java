package com.hfwas.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hfwas.springcloud.entities.CommonResult;

/**
 * @Author HFwas
 * @Date 2021/11/30 23:26
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义exception-------1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义exception-------2");
    }

}
