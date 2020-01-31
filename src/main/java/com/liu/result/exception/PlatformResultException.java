package com.liu.result.exception;

import com.liu.result.entity.PlatformResult;

/**
 * 统一返回异常
 */
public class PlatformResultException extends RuntimeException {
    private PlatformResult result;

    public PlatformResultException(PlatformResult result){
        super(result.toString());
        this.result = result;
    }

    public PlatformResult getResult() {
        return result;
    }
}
