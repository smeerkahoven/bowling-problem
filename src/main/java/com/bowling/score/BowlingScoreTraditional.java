package com.bowling.score;

import com.bowling.controller.BowlingScoreGame;
import com.bowling.model.BowlingException;
import com.bowling.model.BowlingScoreFrame;
import com.bowling.model.BowlingScoreFrameLast;
import com.bowling.model.BowlingScoreLane;

public class BowlingScoreTraditional implements BowlingScoreAlgorithm{

    @Override
    public BowlingScoreLane score(BowlingScoreLane lane) throws BowlingException {

        BowlingScoreFrame currentFrame = lane.getCurrentScoreFrame() ;

        switch (currentFrame.getCurrentBall()) {
            case 1 :
                if (currentFrame.getBallOne() == BowlingScoreGame.STRIKE) {
                    lane = this.applyStrikeScoring(lane, 2) ;
                    if (lane.getCurrentFrame() < BowlingScoreLane.MAX_LANE) {
                        lane.goToNextFrame();
                    }else {
                        //TODO throw Exception Cause Maximun Frame achieved.
                    }
                }

                currentFrame.setCurrentBall(2);
                break;
            case 2 :
                if (currentFrame instanceof BowlingScoreFrameLast){
                    if (currentFrame.getBallTwo() == BowlingScoreGame.STRIKE) {
                        lane = this.applyStrikeScoring(lane, 1) ;
                        if (lane.getCurrentFrame() < BowlingScoreLane.MAX_LANE) {
                            lane.goToNextFrame();
                        }
                    } else {

                    }
                    ((BowlingScoreFrameLast)currentFrame).setCurrentBall(3);
                }
                break;
            case 3:
                if (currentFrame instanceof BowlingScoreFrameLast){
                    if (((BowlingScoreFrameLast) currentFrame).getBallThree() == BowlingScoreGame.STRIKE) {
                        lane = this.applyStrikeScoring(lane, 0) ;
                        lane.goToNextFrame();
                    }
                }

                break;
        }
        return lane ;
    }

    /**
     *
     * @param lane
     * @param decrementor
     * @return
     */
    private BowlingScoreLane applyStrikeScoring(BowlingScoreLane lane , int decrementor){
        lane.strike();
        if (lane.getStrikeCounter() == 3){
            assignScoreToFrame(lane,lane.getCurrentFrame(),
                    lane.getCurrentFrame()- decrementor) ;
            lane.setStrikeCounter( lane.getStrikeCounter() -1 );
        }

        return lane ;
    }

    /**
     *
     * @param lane
     * @param fromPosition
     * @param toPosition
     */
    private void assignScoreToFrame( BowlingScoreLane lane, int fromPosition, int toPosition) {
        int score = 0 ;
        int ballOne = 0 ;
        int ballTwo = 0 ;

        BowlingScoreFrame toFrame = lane.getFrame(toPosition);

        for (int i = fromPosition; i>= toPosition; i--) {
            BowlingScoreFrame scoreFrame = lane.getFrame(i);
            ballOne = scoreFrame.getBallOne() ;
            ballTwo = scoreFrame.getBallTwo() ;

            if (ballTwo != BowlingScoreFrame.INITIAL) {
                score += ballOne + ballTwo ;
            }else {
                score += ballOne ;
            }


            if (scoreFrame instanceof BowlingScoreFrameLast) {

                int ballThree =( (BowlingScoreFrameLast)scoreFrame).getBallThree() ;

                if (ballThree != BowlingScoreFrame.INITIAL)
                score += ballThree ;
            }
        }

        toFrame.setScore(score + lane.getTotal());

        lane.setTotal(toFrame.getScore());

    }
}
