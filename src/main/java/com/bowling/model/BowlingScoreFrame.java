package com.bowling.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BowlingScoreFrame {

    public static int INITIAL = -1 ;
    public static int INCORRECT = -2 ;
    public static int EMPTY = 0 ;

    protected int ballOne = INITIAL ;
    protected int ballTwo = INITIAL ;
    protected int score = INITIAL ;
    protected int position ;

    protected int currentBall = 1 ;

    public BowlingScoreFrame(int position) {
        this.position = position ;
    }


}
