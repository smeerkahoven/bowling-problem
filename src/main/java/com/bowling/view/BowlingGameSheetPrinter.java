package com.bowling.view;

import com.bowling.BowlingUtils;
import com.bowling.model.BowlingScoreFrame;
import com.bowling.model.BowlingScoreSheet;

import java.util.Map;

public class BowlingGameSheetPrinter implements  BowlingGamePrinter {

    private static final String TAB = "\t" ;
    @Override
    public void print(final BowlingScoreSheet sheet) {

        StringBuffer output = new StringBuffer() ;

        System.out.println(printHeader());

        // print body
        sheet.getLanes().forEach((k,v)-> {
            String pinfalls = "" ;
            String score = "";

            for (Map.Entry element : v.getFrames().entrySet()){
                BowlingScoreFrame f =(BowlingScoreFrame) element.getValue();
                pinfalls += f.toString() + TAB;
                score += String.format("%d\t\t", f.getScore());
            }

            System.out.println(String.format("%s", k));
            System.out.println(String.format("Pinfalls\t %s", pinfalls));
            System.out.println(String.format("Score\t\t%s",score));
        });
    }

    public String printHeader () {
        String line = "Frame" + TAB + TAB ;

        for (int i = 1 ; i <=10 ; i++ ) {
            if (i <10) {
                line += String.format("%d\t\t", i);
            }else {
                line += String.format("%d",i);
            }
        }

        return line ;
    }




}
