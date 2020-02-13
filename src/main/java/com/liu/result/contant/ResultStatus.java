package com.liu.result.contant;

import lombok.Getter;

/**
 * 请求状态枚举类
 * 后续可以添加其他状态
 *
 * 1xx 信息，服务器收到请求，需要请求者继续执行操作
 * 2xx 成功，操作被成功接收并处理
 * 3xx 重定向，需要进一步的操作以完成请求
 * 4xx 客户端错误，请求包含语法错误或无法完成请求
 * 5xx 服务器错误，服务器在处理请求的过程中发生了错误
 * @author lyh
 */
@Getter
public enum ResultStatus {
    /**
     * 成功请求
     */
    SUCCESS(200, "SUCCESS", "成功请求"),

    /**
     * 永久移动
     */
    MOVED_PERMANENTLY(301, "Moved Permanently", "客户试图访问的资源已移到新的永久位置"),
    /**
     * 临时移动
     */
    FOUND(302, "Found", "资源临时被移动"),

    /**
     * 错误请求
     */
    BAD_REQUEST(400, "Bad Request", "客户端请求的语法错误，服务器无法理解"),
    /**
     * 未经授权
     */
    UNAUTHORIZED(401, "Unauthorized", "请求要求用户的身份认证"),
    /**
     * 服务器接收到了请求但不想搭理你
     */
    FORBIDDEN(403,"Forbidden", "服务器理解请求客户端的请求，但是拒绝执行此请求"),
    /**
     * 您所请求的资源无法找到
     */
    NOT_FOUND(404, "Not Found", "您所请求的资源无法找到"),
    /**
     * 客户端试图使用一个本资源不支持的HTTP方法
     */
    METHOD_NOT_ALLOWD(405, "Method Not Allowd", "客户端试图使用一个本资源不支持的HTTP方法"),
    /**
     * 服务器无法根据客户端请求的内容特性完成请求
     */
    NOT_ACCEPTABLE(406, "Not Acceptable", "服务器无法根据客户端请求的内容特性完成请求"),
    /**
     * 客户端请求的资源已经不存在被永久删除了
     */
    GONE(410, "Gone", "客户端请求的资源已经不存在被永久删除了"),

    /**
     * 内部服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "内部服务器错误");


    /**
     * 请求状态
     */
    private Integer code;
    /**
     * 请求状态信息
     */
    private String message;
    /**
     * 请求描述信息
     */
    private String description;

    ResultStatus(Integer code, String message, String description){
        this.code = code;
        this.message = message;
        this.description = description;
    }
}
