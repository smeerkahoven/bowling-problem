package com.bowling.model;

import com.bowling.BowlingUtils;
import com.bowling.controller.BowlingScoreGame;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BowlingScoreFrame {


    protected int ballOne = BowlingUtils.INITIAL ;
    protected int ballTwo = BowlingUtils.INITIAL ;
    protected int score = BowlingUtils.INITIAL ;
    protected int position ;

    protected int currentBall = 1 ;

    public BowlingScoreFrame() {
    }

    public BowlingScoreFrame withPosition(int position){
        this.position = position ;
        return this ;
    }

    public boolean isSpare () {
        if (currentBall == 2){
            if (ballOne != BowlingUtils.INITIAL && ballTwo != BowlingUtils.INITIAL){
                return (ballOne + ballTwo == BowlingScoreGame.SPARE) ;
            }
        }
        return false ;
    }

    public String toString(){
        String output ="" ;
        if (ballOne == BowlingUtils.STRIKE) {
            output += String.format("%s\t",BowlingUtils.STRIKE_X) ;
        }else if ( (ballOne + ballTwo)== BowlingUtils.SPARE ){
            output += String.format("%d\t/", ballOne);
        }else {
            output += String.format("%d\t%d", ballOne, ballTwo);
        }
        return output ;
    }


}