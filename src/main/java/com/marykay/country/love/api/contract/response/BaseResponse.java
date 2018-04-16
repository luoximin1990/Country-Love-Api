package com.marykay.country.love.api.contract.response;

import java.io.Serializable;
import java.util.List;

public class BaseResponse<T> implements Serializable {
    private int Code = 0;

    private T Data;

    private String Message;

    private List<String> Error;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public List<String> getError() {
        return Error;
    }

    public void setError(List<String> error) {
        Error = error;
    }
}
