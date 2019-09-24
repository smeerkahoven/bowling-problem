package com.bowling.model;

import com.bowling.view.BowlingGameSheetPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BowlingScoreFrameNormal.class, BowlingScoreFrameLast.class})
public class BowlingScoreFrameTest {


    @Test
    public void areThrowCorrectTest() {
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(5);
        frame.setBallTwo(3);

        assertTrue(frame.areThrowsCorrect());
    }

    @Test
    public void areThrowCorrectLastTest() {
        BowlingScoreFrameLast frame = new BowlingScoreFrameLast();
        frame.setPosition(1);
        frame.setCurrentBall(3);
        frame.setBallOne(5);
        frame.setBallTwo(3);
        frame.setBallThree(7);

        assertTrue(frame.areThrowsCorrect());
    }


    @Test
    public void isSpareTest() {

        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setCurrentBall(2);
        frame.setBallOne(5);
        frame.setBallTwo(5);

        assertTrue(frame.isSpare());
    }

    @Test
    public void isSpareLastTest() {

        BowlingScoreFrameLast frame = new BowlingScoreFrameLast();
        frame.setPosition(10);
        frame.setCurrentBall(3);
        frame.setBallOne(5);
        frame.setBallTwo(7);
        frame.setBallThree(3);

        assertTrue(frame.isSpare());
    }


    @Test
    public void testToStringNotSpareNeitherStrike(){
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(5);
        frame.setBallTwo(3);

        assertTrue("5\t3".equalsIgnoreCase(frame.toString()));
    }

    @Test
    public void testToStringStrike(){
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(10);
        frame.setBallTwo(3);

        assertTrue("X\t".equalsIgnoreCase(frame.toString()));
    }

    @Test
    public void testToStringSpare(){
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(7);
        frame.setBallTwo(3);

        assertTrue("7\t/".equalsIgnoreCase(frame.toString()));
    }
}


