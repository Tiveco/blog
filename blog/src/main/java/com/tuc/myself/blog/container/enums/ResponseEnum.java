package com.tuc.myself.blog.container.enums;

/**
 * @Auther: tuc
 * @Date: 2020-01-16 11:18
 */
public enum ResponseEnum {

    /**
     * 成功
     */
    SUCCESS(200, "success"),


    /**
     * 失败
     */
    FAIL(400, "fail"),

    /**
     * 错误
     */
    FALSE(404, "false"),

    /**
     * token过期
     */
    EXPIRED(401,"expired"),

    /**
     * 无权限
     */
    NODEFINED(403, "nodefined"),

    /**
     * 内部错误
     */
    ERROR(500,"error");

    private int code;

    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
