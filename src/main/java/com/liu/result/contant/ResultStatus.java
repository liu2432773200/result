package com.liu.result.contant;

import lombok.Getter;

/**
 * 请求状态枚举类
 */
@Getter
public enum ResultStatus {
    /**
     * 成功请求
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 错误请求(包括非法请求)
     */
    BAD_REQUEST(400, "Bad Request"),
    /**
     * 内部服务器错误
     * ERROR级别
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    /**
     * 请求状态
     */
    private Integer  code;
    /**
     * 请求状态信息
     */
    private String message;

    ResultStatus(Integer  code, String message){
        this.code = code;
        this.message = message;
    }

}
