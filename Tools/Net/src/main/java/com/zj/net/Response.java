package com.zj.net;


/**
 * 根据服务端返回结构设置
 * User: ljx
 * Date: 2018/10/21
 * Time: 13:16
 */
public class Response<T> {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
