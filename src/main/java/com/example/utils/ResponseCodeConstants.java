package com.example.utils;

/**
 * @author Jayson
 */

public enum ResponseCodeConstants {
    SUCCESS("200", "接口调用成功"),
    FAIL("300", "业务处理失败"),
    PARAM_INPUT_INVALID("400", "参数校验非法"),
    NO_PERMISSION("401", "权限不足!"),
    NO_LOGIN("403", "请登录"),
    UNKOWN_SYSTEM_ERROR("500", "未知系统异常"),
    HSF_TIMEOUT("501", "后端接口调用超时"),
    NO_DATA("1000", "未查询到数据"),
    USER_NOT_FOUND("1001", "用户不存在"),
    PASSWORD_ERROR("1002", "密码错误"),
    USER_EXIST("1003", "账号已存在");

    private String code;
    private String message;

    private ResponseCodeConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessageByCode(String code) {
        ResponseCodeConstants[] ae = values();

        for(int i = 0; i < ae.length; ++i) {
            if (ae[i].getCode().equals(code)) {
                return ae[i].getMessage();
            }
        }

        return null;
    }

    public final boolean equals(ResponseCodeConstants other) {
        return this.code == other.getCode();
    }

    @Override
    public String toString() {
        return "Code: " + this.code + ";Messge: " + this.message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

