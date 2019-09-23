package com.bowling.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BowlingPlayer implements Comparable<String> {
    private String name ;

    public BowlingPlayer(){
    }
    @Override
    public int compareTo(String name) {
        return this.name.equalsIgnoreCase(name) ? 1 : 0;
    }
}
