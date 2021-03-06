package com.bowling.main;

import com.bowling.exception.BowlingException;
import com.bowling.controller.BowlingScoreGame;
import com.bowling.controller.BowlingScoreGameTraditional;
import com.bowling.controller.BowlingScoreParserFile;
import com.bowling.model.BowlingToken;
import com.bowling.view.BowlingGamePrinter;
import com.bowling.view.BowlingGameSheetPrinter;
import lombok.Getter;

@Getter
public class BowlingScoreApp {

    private BowlingScoreGame game;

    private BowlingScoreParserFile parser;

    private BowlingGamePrinter printer  ;

    private String file ;

    public void init(String file) throws BowlingException {
        game = new BowlingScoreGameTraditional();
        parser = new BowlingScoreParserFile(file);
        printer = new BowlingGameSheetPrinter();

        this.start();
    }

    public BowlingScoreApp()  {

    }

    public void start() throws BowlingException {
        BowlingToken token;
        boolean allIsOK = true ;
        while ((token = parser.getNextItem()) != null && allIsOK) {
            if (this.parser.isValid(token)) {
                game.processThrow(token);
            }else {
                //invalid Token
                allIsOK = false ;
            }
        }

        if (allIsOK) {
            printer.print(((BowlingScoreGameTraditional)game).getScoreSheet());
        }else {
            throw new BowlingException("There are errors parsing file. You must send valid name and score ");
        }
    }


}
