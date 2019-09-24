package com.bowling.controller;

import com.bowling.BowlingUtils;
import com.bowling.exception.BowlingException;
import com.bowling.model.BowlingToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BowlingScoreParserFile {

    private static final String SPACE = " " ;

    private Scanner scanner ;

    public BowlingScoreParserFile(String file) throws BowlingException {
        this.createFile(file);
    }

    private void createFile (String file)throws BowlingException  {
        File f = new File(file) ;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new BowlingException(e.getMessage());
        }
    }

    public BowlingToken getNextItem() {

        String value = "" ;
        String key = "" ;

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer lineToken = new StringTokenizer(line, SPACE);

            boolean valueIsAssigned = false ;
            boolean keyIsAssigned = false ;

            while (lineToken.hasMoreTokens()
                && (!valueIsAssigned
                || !keyIsAssigned) ) {

                if (!keyIsAssigned) {
                    key = lineToken.nextToken() ;
                    keyIsAssigned = true ;
                }else if (!valueIsAssigned) {
                    value = lineToken.nextToken() ;
                    valueIsAssigned = true ;
                }
            }

            if (valueIsAssigned && keyIsAssigned) {
                Integer newValue = convertValueToValidPin(value);

                return new BowlingToken(key, newValue);
            }
        }
        return null ;
    }

    public boolean isValid(BowlingToken token) {
        return token != null && token.getKey() != null && token.getValue()!= BowlingUtils.INVALID ;
    }

    /**
     * Convert values to a Correct Pin Value
     * if F value is send or return 0
     * if value is in ALLOWED_SET of values returns the value
     * else return invalid value
     * @param value
     * @return
     */
    private Integer convertValueToValidPin(String value){

        if (value.equals(BowlingUtils.FAIL)) {
            return 0 ;
        }

        if (BowlingUtils.ALLOWED_SET.contains(value)){
            return Integer.parseInt(value);
        }

        return BowlingUtils.INVALID ;
    }

}
