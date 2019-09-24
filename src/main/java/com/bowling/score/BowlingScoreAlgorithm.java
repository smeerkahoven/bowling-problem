package com.bowling.score;

import com.bowling.exception.BowlingException;
import com.bowling.model.BowlingScoreLane;

public interface BowlingScoreAlgorithm {

    public BowlingScoreLane score( BowlingScoreLane lane) throws BowlingException;
}
