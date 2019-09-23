package com.bowling.controller;

import com.bowling.model.BowlingException;
import com.bowling.model.BowlingToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BowlingScoreParserFile {


    private static final Integer INVALID = -1 ;
    private static final String FAIL = "F" ;
    private static final String [] ALLOWED_VALUES= new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ,"10", FAIL};
    private static final Set<String> ALLOWED_SET = new HashSet<>(Arrays.asList(ALLOWED_VALUES));

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
        return token != null && token.getKey() != null && token.getValue()!= INVALID ;
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

        if (value.equals(FAIL)) {
            return 0 ;
        }

        if (ALLOWED_SET.contains(value)){
            return Integer.parseInt(value);
        }

        return INVALID ;
    }

}
