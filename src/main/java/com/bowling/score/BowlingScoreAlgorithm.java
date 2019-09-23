package com.bowling.score;

import com.bowling.model.BowlingException;
import com.bowling.model.BowlingScoreLane;

public interface BowlingScoreAlgorithm {

    public BowlingScoreLane score( BowlingScoreLane lane) throws BowlingException;
}
