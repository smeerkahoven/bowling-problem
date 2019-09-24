package com.bowling.main;

import com.bowling.exception.BowlingException;
import com.bowling.controller.BowlingScoreGame;
import com.bowling.controller.BowlingScoreGameTraditional;
import com.bowling.controller.BowlingScoreParserFile;
import com.bowling.model.BowlingToken;
import com.bowling.view.BowlingGamePrinter;
import com.bowling.view.BowlingGameSheetPrinter;

public class BowlingScoreApp {

    private BowlingScoreGame game;

    private BowlingScoreParserFile parser;

    private BowlingGamePrinter printer  ;

    public BowlingScoreApp(String file) throws BowlingException {
        game = new BowlingScoreGameTraditional();
        parser = new BowlingScoreParserFile(file);
        printer = new BowlingGameSheetPrinter();
    }

    public void start() throws BowlingException {
        BowlingToken token;
        boolean allIsOK = true ;
        while ((token = parser.getNextItem()) != null) {
            System.out.println(String.format("key: %s, value: %d", token.getKey(), token.getValue()));

            if (this.parser.isValid(token)) {
                game.processThrow(token);
            }else {
                //invalid Token
                allIsOK = false ;
            }

        }

        if (allIsOK) {
            printer.print(((BowlingScoreGameTraditional)game).getScoreSheet());
        }
    }


}
