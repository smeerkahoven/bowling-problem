package com.bowling.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Lane of the Bowling Game
 */
public class BowlingScoreLane {

    private BowlingPlayer player ;
    private List<BowlingFrame> frames ;
    private int total ;

    public BowlingScoreLane(BowlingPlayer player) {
        this.player = player ;
        initiate();
    }

    /**
     *  Initiate to 10 the current Score Lane
     */
    private void initiate() {
        frames = new ArrayList<>();

        for(int i =1 ;i<=10 ; i++){
            if (i == 10) {
                frames.add(new BowlingFrameLast(i));
            }else {
                frames.add(new BowlingFrameNormal(i));
            }
        }
    }

    public int getTotal (){
        return this.total ;
    }

}
