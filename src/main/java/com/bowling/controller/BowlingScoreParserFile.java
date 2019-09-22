package com.bowling.controller;

import com.bowling.model.BowlingToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BowlingScoreParserFile {

    private static final String TAB = "\t" ;

    private Scanner scanner ;

    public BowlingScoreParserFile(String file) throws FileNotFoundException {

        File f = new File(file) ;

        scanner = new Scanner(file);

    }

    public BowlingToken getNextItem() {

        String value = "" ;
        String key = "" ;

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer lineToken = new StringTokenizer(line, TAB);

            boolean valueIsAssigned = false ;
            boolean keyIsAssigned = false ;

            while (lineToken.hasMoreTokens()
                && !valueIsAssigned
                && !keyIsAssigned) {

                if (!valueIsAssigned) {
                    value = lineToken.nextToken() ;
                    valueIsAssigned = true ;
                }else if (!keyIsAssigned) {
                    key = lineToken.nextToken() ;
                    keyIsAssigned = true ;
                }
            }
        }

    }



}
