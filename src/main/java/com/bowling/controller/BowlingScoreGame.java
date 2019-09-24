package com.bowling.controller;

import com.bowling.exception.BowlingException;
import com.bowling.model.BowlingScoreLane;
import com.bowling.model.BowlingToken;

public interface BowlingScoreGame {

    public final static Integer STRIKE = 10 ;

    public final static Integer SPARE = 10 ;
    /**
     * Process Each throw
     * @param token
     */
    public void processThrow (BowlingToken token) throws BowlingException;


    /**
     *
     * @param token
     * @return
     */
    public BowlingScoreLane addLaneToScoreSheet(BowlingToken token) ;

    /**
     * Checks if Token has 10 of value
     * @param token
     * @return
     */
    public boolean isStrike (BowlingToken token) ;

}

