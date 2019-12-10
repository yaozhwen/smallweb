package com.yao.core.common;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class JsonResult<T>
{
    public enum Status {
        success,
        error,
        revoke,
        unknown
    }

    private Status status;
    private String message;
    private T value;
    private String code;

    public JsonResult() {
    }

    public JsonResult(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public JsonResult(Status status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public JsonResult(Status status, String message, T value) {
        this.status = status;
        this.message = message;
        this.value = value;
    }

    public JsonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(Status status, T value) {
        this.status = status;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", value=" + value +
                ", code='" + code + '\'' +
                '}';
    }
}
