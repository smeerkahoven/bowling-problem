package com.bowling.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BowlingToken{
    private String key ;
    private Integer value ;

    public BowlingToken(String key, Integer value) {
        this.key = key ;
        this.value = value ;
    }




}
