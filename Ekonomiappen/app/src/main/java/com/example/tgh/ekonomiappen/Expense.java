package com.example.tgh.ekonomiappen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TGH on 10/3/2014.
 */
public class Expense {
    private int id;
    private String title;
    private String date;
    private String price;
    private String category;

    public Expense() {
    }

    public Expense(int id, String title, String date, String price, String category){
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

    public void setPrice (String price){
        this.price = price;
    }

    public String getExpense (){
        String res =
                "            Title:    " + title + "\n\n" +
                "            Date:     " + date + "\n\n" +
                "            Price:    " + price + "\n\n" +
                "            Category: " + category;
        return res;
    }
    public void setCategory (String category){
        this.category = category;
    }

    public String toString() {
        return title;
    }
}
