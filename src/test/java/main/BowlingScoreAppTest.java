package main;

import com.bowling.controller.BowlingScoreGameTraditional;
import com.bowling.exception.BowlingException;
import com.bowling.main.BowlingScoreApp;
import com.bowling.model.BowlingPlayer;
import com.bowling.model.BowlingScoreLane;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BowlingScoreApp.class
        , BowlingScoreGameTraditional.class})
public class BowlingScoreAppTest {

    @Parameter
    public String fileStrike ="/home/xeio/IdeaProjects/bowling-problem/score_strike.txt" ;

    @Parameter
    public String fileSpare ="/home/xeio/IdeaProjects/bowling-problem/score_spare.txt" ;

    @Parameter
    public String fileZero ="/home/xeio/IdeaProjects/bowling-problem/score_zero.txt" ;


    /**
     * This must check if score for user Jeff must be 300
     * the perfect game
     * @throws BowlingException
     */
    @Test
    public void testStrikeApp() throws BowlingException {
        BowlingScoreApp app  = new BowlingScoreApp();
        app.init(fileStrike);

        BowlingScoreGameTraditional game = (BowlingScoreGameTraditional)app.getGame();

        BowlingScoreLane lane = game.getScoreSheet().getPlayerLane("Jeff") ;

        int score = 300 ;

        assertTrue(lane.getTotal() == score);
    }

    /**
     *  Here I test all game with two players.
     *
     *  Score for Jeff player must be 167
     *
     * @throws BowlingException
     */
    @Test
    public void testSpareApp() throws BowlingException {
        BowlingScoreApp app  = new BowlingScoreApp();
        app.init(fileSpare);

        BowlingScoreGameTraditional game = (BowlingScoreGameTraditional)app.getGame();

        BowlingScoreLane lane = game.getScoreSheet().getPlayerLane("Jeff") ;

        int score = 167 ;

        assertTrue(lane.getTotal() == score);
    }

    /**
     *  Here I test zero score.
     *
     *  Score for Jeff player must be 167
     *
     * @throws BowlingException
     */
    @Test
    public void testSpareZerro() throws BowlingException {
        BowlingScoreApp app  = new BowlingScoreApp();
        app.init(fileZero);

        BowlingScoreGameTraditional game = (BowlingScoreGameTraditional)app.getGame();

        BowlingScoreLane lane = game.getScoreSheet().getPlayerLane("Jeff") ;

        int score = 0 ;

        assertTrue(lane.getTotal() == score);
    }
}
