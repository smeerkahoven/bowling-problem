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
    public void testToStringNotSpareNeitherStrike(){
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(5);
        frame.setBallTwo(3);

        assertTrue("5\t\t3".equalsIgnoreCase(frame.toString()));
    }

    @Test
    public void testToStringStrike(){
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(10);
        frame.setBallTwo(3);

        assertTrue("X".equalsIgnoreCase(frame.toString()));
    }

    @Test
    public void testToStringSpare(){
        BowlingScoreFrameNormal frame = new BowlingScoreFrameNormal();
        frame.setPosition(1);
        frame.setBallOne(7);
        frame.setBallTwo(3);

        assertTrue("7\t\t/".equalsIgnoreCase(frame.toString()));
    }
}


