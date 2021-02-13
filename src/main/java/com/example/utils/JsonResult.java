package com.example.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.util.StringUtils;


import java.io.Serializable;


@Data
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 6672279171437608610L;
    private String code;
    private String msg;
    private T data;

    public JsonResult() {
        this(ResponseCodeConstants.SUCCESS, null, null);
    }

    public static JsonResult newSucc() {
        JsonResult rst = new JsonResult();
        rst.setCode(ResponseCodeConstants.SUCCESS.getCode());
        rst.setSuccess(true);
        return rst;
    }

    public static <T> JsonResult<T> newSucc(T t) {
        JsonResult<T> rst = new JsonResult();
        rst.setCode(ResponseCodeConstants.SUCCESS.getCode());
        rst.setData(t);
        rst.setSuccess(true);
        return rst;
    }

    public static JsonResult successReturn() {
        JsonResult rst = new JsonResult();
        rst.setCode(ResponseCodeConstants.SUCCESS.getCode());
        rst.setSuccess(true);
        rst.setMsg("success");
        return rst;
    }


    public static JsonResult failReturn(Integer code,String msg) {
        JsonResult rst = new JsonResult();
        rst.setCode(String.valueOf(code));
        rst.setSuccess(false);
        rst.setMsg(msg);
        return rst;
    }


/*    public static <T> JsonResult<T> newFail(ResponseCodeConstants responseCodeConstants) {
        return newFail(responseCodeConstants, (String) null);
    }*/

    public static <T> JsonResult<T> newFail(String msg) {
        JsonResult<T> rst = new JsonResult();
        rst.setMsg(msg);
        rst.setCode(ResponseCodeConstants.FAIL.getCode());
        rst.setSuccess(false);
        return rst;
    }

/*    public static <T> JsonResult<T> newFail(ResponseCodeConstants responseCodeConstants, String msg) {
        JsonResult<T> rst = new JsonResult();
        rst.putError(responseCodeConstants);
        if (StringUtils.isEmpty(msg)) {
            rst.setMsg(msg);
        } else {
            rst.setMsg(responseCodeConstants.getMessage());
        }

        return rst;
    }*/

    public static <T> JsonResult<T> newFail(String code, String msg) {
        JsonResult<T> rst = new JsonResult();
        rst.setMsg(msg);
        rst.setCode(code);
        rst.setSuccess(false);
        return rst;
    }

    public void putData(T data) {
        this.code = ResponseCodeConstants.SUCCESS.getCode();
        this.setMsg(ResponseCodeConstants.SUCCESS.getMessage());
        this.setData(data);
    }

    public JsonResult(ResponseCodeConstants responseCode, String msg, T data) {
        this.code = responseCode.getCode();
        this.data = data;
        this.msg = msg;
    }

    public JsonResult(String code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.code == ResponseCodeConstants.SUCCESS.getCode();
    }

    public void setSuccess(boolean success) {
        if (success) {
            this.code = ResponseCodeConstants.SUCCESS.getCode();
        } else {
            if (StringUtils.isEmpty(this.code)) {
                this.code = ResponseCodeConstants.FAIL.getCode();
            }
            if (StringUtils.isEmpty(this.msg)) {
                this.msg = ResponseCodeConstants.FAIL.getMessage();
            }
        }

    }

    public void markSuccess() {
        this.code = ResponseCodeConstants.SUCCESS.getCode();
        this.setMsg(ResponseCodeConstants.SUCCESS.getMessage());
    }

    public void putError(ResponseCodeConstants error) {
        this.code = error.getCode();
        this.msg = error.getMessage();
    }

    public void putError(Throwable e) {
        this.code = ResponseCodeConstants.UNKOWN_SYSTEM_ERROR.getCode();
        this.msg = e.getMessage();
    }

    public void putError(ResponseCodeConstants error, String msg) {
        this.code = error.getCode();
        this.msg = error.getMessage() + ":" + msg;
    }

    public void putError(ResponseCodeConstants error, Exception e) {
        this.code = error.getCode();
        this.msg = error.getMessage() + ".   " + e.getMessage();
    }

    public void putError(ResponseCodeConstants error, String msg, Exception e) {
        this.code = error.getCode();
        this.msg = error.getMessage() + ":" + msg + ".   " + JSON.toJSONString(e.getMessage());
    }


}
