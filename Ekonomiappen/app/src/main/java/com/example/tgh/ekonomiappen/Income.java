package com.example.tgh.ekonomiappen;

/**
 * Created by TGH on 10/3/2014.
 */
public class Income {
    private int id;
    private String title;
    private String date;
    private String bellop;
    private String category;

    public Income() {
    }

    public Income(int id, String title, String date, String bellop, String category){
        this.id = id;
        this.title = title;
        this.date = date;
        this.bellop = bellop;
        this.category = category;
    }

    public int getId (){
        return id;
    }

    public String getTitle (){
        return title;
    }

    public String getDate (){
        return date;
    }

    public String getBellop (){
        return bellop;
    }

    public String getCategory (){
        return date;
    }

    public void setId (int id){
        this.id = id;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public void setDate (String date){
        this.date = date;
    }

    public void setBellop (String price){
        this.bellop = bellop;
    }

    public void setCategory (String category){
        this.category = category;
    }
}
