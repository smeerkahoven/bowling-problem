package com.bowling.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BowlingScoreFrameLast extends BowlingScoreFrame {

    private int ballThree = BowlingScoreFrame.INITIAL ;

    public BowlingScoreFrameLast(int position) {
        super(position);
    }
}
