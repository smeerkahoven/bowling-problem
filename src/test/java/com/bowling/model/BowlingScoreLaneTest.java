package com.bowling.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BowlingScoreLane.class})

public class BowlingScoreLaneTest {

    @Test
    public void incrementStrikeTest() {
        BowlingScoreLane lane = new BowlingScoreLane();
        lane.incrementStrike();

        assertTrue(1 == lane.getStrikeCounter());
    }

    @Test
    public void incrementSpareTest() {
        BowlingScoreLane lane = new BowlingScoreLane();
        lane.incrementSpare();

        assertTrue(1 == lane.getSpareCounter());
    }

    @Test
    public void decrementStrikeTest() {

        BowlingScoreLane lane = new BowlingScoreLane();
        lane.incrementStrike();
        lane.incrementStrike();
        lane.decrementStrikes();

        assertTrue(1 == lane.getStrikeCounter());

    }

    @Test
    public void decrementSpareTest() {

        BowlingScoreLane lane = new BowlingScoreLane();
        lane.incrementSpare();
        lane.incrementSpare();
        lane.decrementSpare();

        assertTrue(1 == lane.getSpareCounter());

    }

    @Test
    public void equalsBowlinStringTest() {
        BowlingScoreLane lane = new BowlingScoreLane();
        BowlingPlayer p = new BowlingPlayer();
        p.setName("Jose");
        lane.setPlayer(p);

        assertTrue(lane.equals("Jose"));
    }
}
