package com.liu.result.exception;

import com.liu.result.contant.ResultStatus;
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
     * @param code      异常码
     * @param message   异常信息
     */
    public PlatformResultException(Integer code, String message){
        this(code, message, null);
    }

    /**
     * 系统内部异常
     * @param code      异常码
     * @param message   异常信息
     * @param <T>       异常数据
     */
    public <T> PlatformResultException(Integer code, String message, T data){
        super(message);
        this.result = PlatformResult.failure(code, message, data);
    }

    /**
     * 系统内部异常
     * @param status    异常状态
     */
    public PlatformResultException(ResultStatus status){
        this(status, null);
    }

    /**
     * 系统内部异常
     * @param status    异常状态
     * @param <T>       异常数据
     */
    public <T> PlatformResultException(ResultStatus status, T data){
        super(status.getMessage());
        this.result = PlatformResult.failure(status, data);
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
