package com.bowling.model;

import com.bowling.BowlingUtils;
import com.bowling.controller.BowlingScoreGame;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BowlingScoreFrameLast extends BowlingScoreFrame {

    private int ballThree = BowlingUtils.INITIAL ;

    public BowlingScoreFrameLast() {
        super();
    }

    @Override
    public boolean isSpare() {
        if (currentBall == 2) {
            if (ballOne != BowlingScoreGame.STRIKE){
                if (ballOne + ballTwo == BowlingScoreGame.SPARE){
                    return true ;
                }
            }
        }else if (currentBall == 3){
            if (ballTwo != BowlingScoreGame.STRIKE){
                if (ballTwo + ballThree == BowlingScoreGame.SPARE){
                    return true ;
                }
            }
        }

        return false ;
    }

    @Override
    public boolean areThrowsCorrect() {
        if (currentBall == 2){
            if (ballOne == BowlingUtils.STRIKE){
                return  true ;
            } else if ( ballOne+ ballTwo <= BowlingUtils.SPARE) {
                return true ;
            }
        }else if (currentBall == 3) {
            if (ballTwo == BowlingUtils.STRIKE){
                return true ;
            }else if (ballTwo + ballThree<= BowlingUtils.SPARE) {
                return true ;
            }
        }
        return false ;
    }

    public String toString(){
        String output ="" ;
            if (ballOne == BowlingUtils.STRIKE) {
                output += BowlingUtils.STRIKE_X + "\t" ;
            }else {
                output += String.format("%d\t",ballOne) ;
            }

            if (ballTwo == BowlingUtils.STRIKE) {
                output += BowlingUtils.STRIKE_X + "\t" ;
            }
            else if (ballOne  + ballTwo == BowlingUtils.SPARE) {
                output += String.format("%s\t",BowlingUtils.SPARE_SLASH) ;
            }else {
                output += String.format("%d\t",ballTwo) ;
            }

            if (ballThree == BowlingUtils.STRIKE) {
                output += String.format("%s",BowlingUtils.STRIKE_X) ;
            }else if (ballTwo+ballThree == BowlingUtils.SPARE) {
                output += String.format("%s",BowlingUtils.SPARE_SLASH) ;
            }else {
                output += String.format("%d\t",ballThree) ;
            }

        return output ;
    }
}