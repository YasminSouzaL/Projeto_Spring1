package com.srayasmin.projetomc.controller.resources;

import java.io.Serializable;

public class StandarError  implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer status;
    private String msg;
    private Long timeStamp;

    public StandarError() {
    }

    public StandarError(Integer status, String msg, Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    // Getters and Setters

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public StandarError status(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public StandarError msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
