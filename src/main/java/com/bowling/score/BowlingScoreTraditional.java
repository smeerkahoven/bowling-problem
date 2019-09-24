package com.bowling.score;

import com.bowling.BowlingUtils;
import com.bowling.controller.BowlingScoreGame;
import com.bowling.exception.BowlingException;
import com.bowling.model.BowlingScoreFrame;
import com.bowling.model.BowlingScoreFrameLast;
import com.bowling.model.BowlingScoreLane;

/**
 * According to Wikipedia there are two algoritms
 * Traditioanl
 */
public class BowlingScoreTraditional implements BowlingScoreAlgorithm {

    @Override
    public BowlingScoreLane score(BowlingScoreLane lane) throws BowlingException {

        BowlingScoreFrame currentFrame = lane.getCurrentScoreFrame();

        switch (currentFrame.getCurrentBall()) {
            case 1:
                // is strike in first throw
                if (currentFrame.getBallOne() == BowlingScoreGame.STRIKE) {
                    applyStrikeScoring(lane, 2);
                    // Only if strikes at first can jump frame
                    if (lane.getCurrentFrame() < BowlingScoreLane.MAX_LANE) {
                        lane.goToNextFrame();
                    }
                } else {
                    if (lane.getStrikeCounter() == 2) {
                        assignScoreToFrame(lane, lane.getCurrentFrame(),
                                lane.getCurrentFrame() - 2);
                        lane.decrementStrikes();
                    } else if (lane.getSpareCounter() > 0) {
                        assignScoreToFrame(lane, lane.getCurrentFrame(),
                                lane.getCurrentFrame() - 1);
                        lane.decrementSpare();
                    }
                }

                currentFrame.setCurrentBall(2);
                break;
            case 2:
                if (currentFrame instanceof BowlingScoreFrameLast) {
                    // is strike in last throw
                    if (currentFrame.getBallTwo() == BowlingScoreGame.STRIKE) {
                        lane = this.applyStrikeScoring(lane, 1);

                    } else {
                        if (currentFrame.isSpare()) {
                            assignScoreToFrame(lane, lane.getCurrentFrame(),
                                    lane.getCurrentFrame() - 1);
                            lane.incrementSpare();
                        }else {
                            checkIfStrikeOnBallTwo(lane);
                        }
                    }
                    ((BowlingScoreFrameLast) currentFrame).setCurrentBall(3);
                } else {
                    int decrementor = 0;

                    if (currentFrame.isSpare()) {
                        checkIfStrikeOnBallTwo(lane);
                        lane.incrementSpare();
                    }else {
                        checkIfStrikeOnBallTwo(lane);
                        assignScoreToFrame(lane, lane.getCurrentFrame(),
                                lane.getCurrentFrame());
                    }
                }
                //all throws from ball2 jump frame
                if (lane.getCurrentFrame() < BowlingScoreLane.MAX_LANE) {
                    lane.goToNextFrame();
                }

                break;
            case 3:
                assignScoreToFrame(lane, lane.getCurrentFrame(),
                        lane.getCurrentFrame() - 0);
                break;
        }
        return lane;
    }

    /**
     * Checks if there is an strike
     * @param lane
     */
    private void checkIfStrikeOnBallTwo(BowlingScoreLane lane){
        //int decrementor = 0 ;
        if (lane.getStrikeCounter() > 0) {
            //decrementor = lane.getStrikeCounter();
            lane.decrementStrikes();
            assignScoreToFrame(lane, lane.getCurrentFrame(),
                    lane.getCurrentFrame() - 1);
        }
    }
    /**
     * @param lane
     * @param decrementor
     * @return
     */
    private BowlingScoreLane applyStrikeScoring(BowlingScoreLane lane, int decrementor) {
        lane.incrementStrike();
        if (lane.getStrikeCounter() > 2 ) {
            assignScoreToFrame(lane, lane.getCurrentFrame(),
                    lane.getCurrentFrame() - decrementor);
            lane.decrementStrikes();
        } else if (lane.getSpareCounter() > 0) {
            assignScoreToFrame(lane, lane.getCurrentFrame(),
                    lane.getCurrentFrame() - 1);
            lane.decrementSpare();
        }

        return lane;
    }

    /**
     * @param lane
     * @param fromPosition
     * @param toPosition
     */
    private void assignScoreToFrame(BowlingScoreLane lane, int fromPosition, int toPosition) {
        int score = 0;
        int ballOne = 0;
        int ballTwo = 0;

        BowlingScoreFrame toFrame = lane.getFrame(toPosition);

        for (int i = fromPosition; i >= toPosition; i--) {
            BowlingScoreFrame scoreFrame = lane.getFrame(i);
            ballOne = scoreFrame.getBallOne();
            ballTwo = scoreFrame.getBallTwo();

            if (ballTwo != BowlingUtils.INITIAL) {
                score += ballOne + ballTwo;
            } else {
                score += ballOne;
            }

            if (scoreFrame instanceof BowlingScoreFrameLast) {
                int ballThree = ((BowlingScoreFrameLast) scoreFrame).getBallThree();
                if (ballThree != BowlingUtils.INITIAL) {
                    score += ballThree;
                }
            }
        }

        toFrame.setScore(score + lane.getTotal());
        lane.setTotal(toFrame.getScore());
    }
}