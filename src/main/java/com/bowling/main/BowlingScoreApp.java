package com.bowling.main;

import com.bowling.controller.BowlingScoreGame;
import com.bowling.controller.BowlingScoreGameTraditional;
import com.bowling.controller.BowlingScoreParserFile;

public class BowlingScoreApp {

    private BowlingScoreGame game ;

    private BowlingScoreParserFile parser ;

    public BowlingScoreApp (String file ){

        game = new BowlingScoreGameTraditional();


    }


}
