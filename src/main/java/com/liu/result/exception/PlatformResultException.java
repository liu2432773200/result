package com.liu.result.exception;

import com.liu.result.entity.PlatformResult;
import lombok.Getter;

/**
 * 统一返回异常
 *
 * @author lyh
 */
public class PlatformResultException extends RuntimeException {
    @Getter
    private PlatformResult result;

    /**
     * 系统内部异常
     * @param message 异常信息
     */
    public PlatformResultException(String message){
        super(message);
        this.result = PlatformResult.failure(message);
    }

    /**
     * 系统内部异常
     * @param result    统一返回异常格式
     */
    public PlatformResultException(PlatformResult result){
        super(result.getMessage());
        this.result = result;
    }

}
