package com.lunatech.assessment.dto;

/**
 * Created by User on 05/28/2017.
 */
public class TopRunWayIdentsDto {
    private String le_ident;
    private long cnt;

    public TopRunWayIdentsDto(String le_ident, long cnt) {
        this.le_ident = le_ident;
        this.cnt = cnt;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public void setLe_ident(String le_ident) {
        this.le_ident = le_ident;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }
}
