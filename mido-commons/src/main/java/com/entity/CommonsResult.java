package com.entity;

import lombok.Data;

@Data
public class CommonsResult {
    private int stateCode;
    private String msg;
    private Object data;

    public static CommonsResult newInstance(int stateCode, Object data, String msg) {
        CommonsResult CommonsResult = new CommonsResult();
        CommonsResult.setStateCode(stateCode);
        CommonsResult.setMsg(msg);
        CommonsResult.setData(data);
        return CommonsResult;
    }

    public static CommonsResult success(Object data, String msg) {
        return newInstance(200, data, msg);
    }
    public static CommonsResult success(Object data) {
        return newInstance(200, data, "操作成功");
    }
    public static CommonsResult success() {
        return newInstance(200, null, "操作成功");
    }

    public static CommonsResult fail(Object data, String msg) {
        return newInstance(500, data, msg);
    }
    public static CommonsResult fail(String msg) {
        return newInstance(500, null, msg);
    }
    public static CommonsResult fail() {
        return newInstance(500, null, "操作失败");
    }
}
