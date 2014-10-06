package com.example.tgh.ekonomiappen;

/**
 * Created by TGH on 10/3/2014.
 */
public class Utgifter {
    private int id;
    private String title;
    private String date;
    private String price;
    private String category;

    public Utgifter() {
    }

    public Utgifter (int id, String title, String date, String price, String category){
        this.id = id;
        this.title = title;
        this.date = date;
        this.price = price;
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

    public String getPrice (){
        return price;
    }

    public String getCategory (){
        return category;
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

    public void setPrie (String price){
        this.price = price;
    }

    public void setCategory (String category){
        this.category = category;
    }
}
