package com.bowling;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BowlingUtils {

    public static final int STRIKE = 10 ;

    public static final int SPARE = 10 ;

    public static final int INITIAL = -1 ;

    public static final int EMPTY = 0 ;

    public static final String STRIKE_X = "X" ;
    public static final String SPARE_SLASH = "/" ;
    public static final String TAB = "\t" ;

    public static final Integer INVALID = -1 ;
    public static final String FAIL = "F" ;
    public static final String [] ALLOWED_VALUES= new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ,"10", FAIL};
    public static final Set<String> ALLOWED_SET = new HashSet<>(Arrays.asList(ALLOWED_VALUES));

}
