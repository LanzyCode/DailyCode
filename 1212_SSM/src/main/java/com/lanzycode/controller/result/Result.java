package com.lanzycode.controller.result;

public class Result {
    //操作结果编码
    private Integer code;
    //操作数据结果
    private Object data;
    //消息字段
    private String message;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Result{");
        sb.append("code=").append(code);
        sb.append(", data=").append(data);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
