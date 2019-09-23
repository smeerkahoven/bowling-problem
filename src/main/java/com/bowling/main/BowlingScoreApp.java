package com.bowling.main;

import com.bowling.model.BowlingException;
import com.bowling.controller.BowlingScoreGame;
import com.bowling.controller.BowlingScoreGameTraditional;
import com.bowling.controller.BowlingScoreParserFile;
import com.bowling.model.BowlingToken;

public class BowlingScoreApp {

    private BowlingScoreGame game;

    private BowlingScoreParserFile parser;

    public BowlingScoreApp(String file) throws BowlingException {
        game = new BowlingScoreGameTraditional();
        parser = new BowlingScoreParserFile(file);
    }

    public void start() throws BowlingException {
        BowlingToken token;

        while ((token = parser.getNextItem()) != null) {
            System.out.println(String.format("key: %s, value: %d", token.getKey(), token.getValue()));

            if (this.parser.isValid(token)) {
                game.processThrow(token);
            }else {
                //invalid Token
            }

        }
    }


}
