package com.bowling.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Getter
public class BowlingScoreSheet {

    /**
     * Lanes for Scoring Sheet
     */
    private HashMap<String,BowlingScoreLane> lanes ;
    //private List<BowlingScoreLane> lanes ;

    public BowlingScoreSheet(){
        lanes = new HashMap<>(10);
    }

    /**
     * Add a new Lane for a PLayer
     * @param lane
     */
    public void addLane(BowlingScoreLane lane){
        lanes.put(lane.getPlayer().getName(), lane);
        /*if (!lanes.contains(lane)) {
            lanes.add(lane);
        }*/
    }

    public BowlingScoreLane getPlayerLane(String player) {
        return lanes.get(player);
    }

    public boolean isEmpty() {
        return lanes.isEmpty() ;
    }

}
