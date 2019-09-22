package com.bowling.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BowlingFrameLast extends  BowlingFrame {

    private short ballThree ;

    public BowlingFrameLast(int position) {
        super(position);
    }
}
