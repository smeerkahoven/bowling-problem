package view;


import com.bowling.model.BowlingPlayer;
import com.bowling.view.BowlingGamePrinter;
import com.bowling.view.BowlingGameSheetPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BowlingGameSheetPrinter.class)
public class BowlingGameSheetPrinterTest {

    @Test
    public void testPrintHeader(){
        String output = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10";

        BowlingGameSheetPrinter printer = new BowlingGameSheetPrinter();

        assertTrue(printer.printHeader().equalsIgnoreCase(output));
    }
}
