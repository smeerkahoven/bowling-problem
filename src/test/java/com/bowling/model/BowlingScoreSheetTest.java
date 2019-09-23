package com.bowling.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BowlingPlayer.class, BowlingScoreSheet.class, BowlingScoreLane.class})
public class BowlingScoreSheetTest {

    @Test
    public void addLane(){

        BowlingPlayer p1 = new BowlingPlayer();
        p1.setName("Jose");

        BowlingScoreLane l1 = new BowlingScoreLane();
        l1.setPlayer(p1);

        BowlingScoreLane l2 = new BowlingScoreLane();
        l2.setPlayer(p1);

        BowlingScoreSheet s1 = new BowlingScoreSheet();
        s1.addLane(l1);
        s1.addLane(l2);

        assertTrue(s1.getLanes().size() == 1); ;

    }

    @Test
    public void getPlayerLaneTest(){

        BowlingPlayer p1 = new BowlingPlayer();
        p1.setName("Jose");

        BowlingScoreLane l1 = new BowlingScoreLane();
        l1.setPlayer(p1);

        BowlingPlayer p2 = new BowlingPlayer();
        p2.setName("Laura");

        BowlingScoreLane l2 = new BowlingScoreLane();
        l2.setPlayer(p2);

        BowlingScoreSheet s1 = new BowlingScoreSheet();
        s1.addLane(l1);
        s1.addLane(l2);

        assertTrue(s1.getPlayerLane("Laura") != null); ;

    }
}
