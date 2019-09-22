package com.bowling.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BowlingFrame {

    protected int ballOne ;
    protected int ballTwo ;
    protected int score ;
    protected int position ;
    protected BowlingPlayer player ;

    public BowlingFrame(int position) {
        this.position = position ;
    }

}
