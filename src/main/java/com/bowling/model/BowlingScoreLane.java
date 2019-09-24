package com.bowling.model;

import com.bowling.exception.BowlingException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * Represents the Lane of the Bowling Game
 */
@Getter
@Setter
public class BowlingScoreLane  {

    public static final int MAX_LANE = 10 ;

    private BowlingPlayer player ;
    private HashMap<Integer, BowlingScoreFrame> frames ;
    private int currentFrame =1 ;
    private int total = 0  ;
    private int strikeCounter = 0 ;
    private int spareCounter = 0 ;

    public BowlingScoreLane() {
        initiate();
    }

    public void incrementStrike() {
        if (strikeCounter <=3 ){
            strikeCounter++ ;
        }
    }

    public void incrementSpare() {
        if (spareCounter <=1 ){
            spareCounter++ ;
        }
    }

    public void decrementStrikes() {
        if (strikeCounter > 0) {
            strikeCounter-- ;
        }
    }

    public void decrementSpare() {
        if (spareCounter > 0) {
            spareCounter-- ;
        }
    }

    /**
     *  Initiate to 10 the current Score Lane
     */
    private void initiate() {
        frames = new HashMap<>(10);
        for(int i =1 ;i<=10 ; i++){
            if (i == 10) {
                frames.put(i, new BowlingScoreFrameLast().withPosition(i));
            }else {
                frames.put(i, new BowlingScoreFrameNormal().withPosition(i));
            }
        }
    }

    public BowlingScoreFrame getCurrentScoreFrame() throws BowlingException {
        if (currentFrame > MAX_LANE)
            throw new BowlingException(String.format("Max Size in Frame Achieved using Player: %s", this.getPlayer().getName()) );

        return frames.get(this.currentFrame);
    }

    public int getTotal (){
        return this.total ;
    }

    public void goToNextFrame() {
        currentFrame++ ;
    }

    public BowlingScoreFrame getFrame(int position) {
        return this.frames.get(position) ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof BowlingScoreLane) {
            BowlingScoreLane laneCompareTo = (BowlingScoreLane)obj ;
            if (this.player!= null && laneCompareTo.getPlayer() != null) {
                return (this.player.getName().equalsIgnoreCase(laneCompareTo.getPlayer().getName()));
            }
        }else if (obj != null && obj instanceof String) {
            String player = (String) obj ;
            if (this.player!= null){
                return this.player.getName().equalsIgnoreCase(player);
            }
        }

        return false;
    }

}