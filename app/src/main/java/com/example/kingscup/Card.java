package com.example.kingscup;

import java.util.Comparator;
import java.util.Random;

public class Card implements Comparable {
    private final int index;
    private final String name;
    private final String description;

    public Card(String name, int index,String description){
        this.name = name;
        this.index = index;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getIndex(){
        return index;
    }

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        if(this.index < card.getIndex()) {
            return 1;
        }else if(this.index > card.getIndex()) {
            return -1;
        }
        else{
            return 0;
        }
    }
}
