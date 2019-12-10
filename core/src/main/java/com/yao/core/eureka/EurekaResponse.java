package com.yao.core.eureka;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class EurekaResponse {
    public enum Status {
        error,
        success,
        hystrix
    }

    private Status status;
    private String code;
    private String message;
    private String value;


    public EurekaResponse() {
    }

    public EurekaResponse(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public EurekaResponse(Status status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public EurekaResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public <T> List<T> getListResult(Class clazz) {
        Type type = new ParameterizedTypeImpl(clazz);
        return new Gson().fromJson(getValue(), type);
    }

    public <T> T getObjectResult(Class<T> clazz) {
        return  new Gson().fromJson(getValue(), clazz);
    }

    @Override
    public String toString() {
        return "EurekaResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", value=" + value +
                ", code='" + code + '\'' +
                '}';
    }

}
