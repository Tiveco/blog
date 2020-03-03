package com.tuc.myself.blog.container;

import com.tuc.myself.blog.container.enums.ResponseEnum;
import lombok.Data;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 14:40
 */
@Data
public class ResponseResult<T> {
    private int code;
    private T data;
    private String message;

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
