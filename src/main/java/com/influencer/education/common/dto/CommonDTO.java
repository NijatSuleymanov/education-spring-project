package com.influencer.education.common.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommonDTO {

    private Object obj;
    private String msg;
    private LocalDateTime time;


    public LocalDateTime getTime() {
        return time;
    }

    public CommonDTO setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CommonDTO setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public CommonDTO setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
