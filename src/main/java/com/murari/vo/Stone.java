package com.murari.vo;

import java.sql.Date;

public class Stone {
    private long id;
    private String content;
    private String qualityRange;
    private long stock; //closing quantity
    private int unit;   //ton
    private Date inDate;
    private String openingQuantity;
    private String comments; //get by who and which vehicle
    private long inStone; // capture stone in at the date
    
    //stone consume properties
    private Date consumeDate;
    private long consumedDate; //how much stone consumed
    private String operator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
