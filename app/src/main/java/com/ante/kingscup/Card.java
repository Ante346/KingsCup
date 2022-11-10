package com.ante.kingscup;

public class Card implements Comparable {
    private final int index;
    private final String name;
    private final String description;
    private int resource;

    public Card(String name, int index,String description,int resource){
        this.name = name;
        this.index = index;
        this.description = description;
        this.resource = resource;
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

    public int getResource(){
        return resource;
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
