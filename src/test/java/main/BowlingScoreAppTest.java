package main;

import com.bowling.exception.BowlingException;
import com.bowling.main.BowlingScoreApp;
import com.bowling.model.BowlingPlayer;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BowlingPlayer.class)
public class BowlingScoreAppTest {

    String pathToFile ;

    private BowlingScoreApp app  ;

    @Before
    public void init() throws BowlingException, IOException {

        pathToFile =  IOUtils.toString(this.getClass().getResourceAsStream("/main/score_spare.txt")) ;
        //app = new BowlingScoreApp(pathToFile);
    }


    @Test
    public void testThrowCaseOne() throws IOException, BowlingException {

        assertTrue("/home/xeio/IdeaProjects/bowling-problem/src/test/java/main/score_spare.txt".equalsIgnoreCase(pathToFile));

    }


}
