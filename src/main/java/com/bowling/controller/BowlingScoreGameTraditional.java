package com.bowling.controller;

import com.bowling.model.*;
import com.bowling.score.BowlingScoreAlgorithm;
import com.bowling.score.BowlingScoreTraditional;

import java.util.Optional;

/**
 * Class for BowlinScore Game For Traditional Methods
 * According to Rules
 */
public class BowlingScoreGameTraditional implements BowlingScoreGame {

    private BowlingScoreSheet scoreSheet = new BowlingScoreSheet();

    private BowlingScoreAlgorithm scoreAlgorithm = new BowlingScoreTraditional() ;

    public BowlingScoreGameTraditional(){
    }

    /**
     * Here we must apply rules
     * @param token
     */
    @Override
    public void processThrow(BowlingToken token) throws BowlingException {

        BowlingScoreLane currentLane ;
        if (scoreSheet.isEmpty()){
            currentLane = addLaneToScoreSheet(token);
        }else {
            currentLane = scoreSheet.getPlayerLane(token.getKey());
            Optional isCurrentLane = Optional.ofNullable(currentLane);

            if (!isCurrentLane.isPresent()) {
                currentLane = addLaneToScoreSheet(token);
            }
        }

        assign(token, currentLane);

        currentLane = scoreAlgorithm.score(currentLane);
    }

    /**
     *
     * @param token
     * @param lane
     */
    private void assign(BowlingToken token, BowlingScoreLane lane)
            throws BowlingException {

        BowlingScoreFrame currentFrame = lane.getCurrentScoreFrame() ;

         if (currentFrame.getBallOne() == BowlingScoreFrame.INITIAL) {
            currentFrame.setBallOne(token.getValue());
        }else if (currentFrame.getBallTwo() == BowlingScoreFrame.INITIAL) {
            currentFrame.setBallTwo(token.getValue());
        } else if (currentFrame instanceof BowlingScoreFrameLast) {
             if (((BowlingScoreFrameLast) currentFrame).getBallThree() == BowlingScoreFrame.INITIAL) {
                ((BowlingScoreFrameLast) currentFrame).setBallThree(token.getValue());
             }
         }
    }


    /**
     * Add the lane to the score sheet
     * @param token
     * @return
     */
    public BowlingScoreLane addLaneToScoreSheet(BowlingToken token){
        BowlingPlayer player = new BowlingPlayer();
        player.setName(token.getKey());

        BowlingScoreLane lane = new BowlingScoreLane();
        lane.setPlayer(player);

        scoreSheet.addLane(lane);

        return lane ;
    }

    @Override
    public boolean isStrike(BowlingToken token) {
        return token.getValue() == STRIKE;
    }


}
