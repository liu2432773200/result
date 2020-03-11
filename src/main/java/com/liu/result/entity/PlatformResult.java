package com.liu.result.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.liu.result.contant.ResultStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 平台通用返回结果
 *
 * @author lyh
 */
@Getter
@ToString
@EqualsAndHashCode
// 若被注解的字段值为 null，则序列化时忽略该字段。
@JsonInclude(JsonInclude.Include.NON_NULL)
// @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PlatformResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息描述
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回时间（时间戳）
     */
    private Long timestamp;

    /**
     * 成功请求 无返回数据
     * @param <Void>  无返回数据
     * @return
     */
    public static<Void> PlatformResult<Void> success() {
        return new PlatformResult<Void>(ResultStatus.SUCCESS, null);
    }

    /**
     * 成功请求需添加返回数据
     * @param data  返回的数据
     * @param <T>   返回数据的类型
     * @return
     */
    public static<T> PlatformResult<T> success(T data) {
        return new PlatformResult<T>(ResultStatus.SUCCESS, data);
    }


    /**
     * 失败请求 无返回数据
     * @param <Void>    无返回数据
     * @return
     */
    public static<Void> PlatformResult<Void> failure() {
        return new PlatformResult<Void>(ResultStatus.INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 失败请求
     * @param message   返回信息描述
     * @param <Void>    返回的数据类型
     * @return
     */
    public static<Void> PlatformResult<Void> failure(String message) {
        return new PlatformResult<Void>(ResultStatus.INTERNAL_SERVER_ERROR.getCode(), message, null);
    }

    /**
     * 失败请求
     * @param code      返回状态码
     * @param message   返回信息描述
     * @param <Void>    返回的数据类型
     * @return
     */
    public static<Void> PlatformResult<Void> failure(Integer code, String message) {
        return new PlatformResult<Void>(code, message, null);
    }

    /**
     * 失败请求
     * @param resultStatus  返回状态
     * @return
     */
    public static<Void> PlatformResult<Void> failure(ResultStatus resultStatus) {
        return failure(resultStatus, null);
    }

    /**
     * 失败请求
     * @param resultStatus  返回状态
     * @param data          返回的数据
     * @param <T>           返回的数据类型
     * @return
     */
    public static<T> PlatformResult<T> failure(ResultStatus resultStatus, T data) {
        if (resultStatus == null) {
            return new PlatformResult<T>(ResultStatus.INTERNAL_SERVER_ERROR, null);
        }
        return new PlatformResult<T>(resultStatus, data);
    }

    /**
     * 失败请求
     * @param code      返回状态码
     * @param message   返回信息描述
     * @param data      返回的数据
     * @param <T>       返回的数据类型
     * @return
     */
    public static<T> PlatformResult<T> failure(Integer code, String message, T data) {
        return new PlatformResult<T>(code, message, data);
    }

    /**
     * 封装ResultCode下的数据
     * @param resultStatus  状态常量
     * @param data          返回的数据
     */
    protected PlatformResult(ResultStatus resultStatus, T data) {
        this(resultStatus.getCode(), resultStatus.getMessage(), data);
    }

    /**
     * 封装返回的数据
     * @param code      状态码
     * @param message   信息描述
     * @param data      数据
     */
    protected PlatformResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;

        timestamp = System.currentTimeMillis();
    }
}

