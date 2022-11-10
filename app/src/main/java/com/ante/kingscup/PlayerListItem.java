package com.ante.kingscup;

public class PlayerListItem {
    private String name = "";
    private int number;

    public PlayerListItem(int number){
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getNumber(){
       return number;
    }
}
