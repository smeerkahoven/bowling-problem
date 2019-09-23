package com.bowling.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = BowlingPlayer.class)
public class BowlinPlayerTest {

    @Test
    public void testCompare(){

        //ApplicationContext context = new AnnotationConfigApplicationContext(BowlingConfiguration.class);
        BowlingPlayer p1 = new BowlingPlayer();
        p1.setName("Jose");
        assertTrue(p1.compareTo("Jose")==1); ;


    }
}
