package com.example.tgh.ekonomiappen;

/**
 * Created by TGH on 10/3/2014.
 */
public class Income {
    private int id;
    private String title;
    private String date;
    private String amount;
    private String category;

    public Income() {
    }

    public Income(int id, String title, String date, String amount, String category){
        this.id = id;
        this.title = title;
        this.date = date;
        this.amount = amount;
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

    public String getAmount (){
        return amount;
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

    public void setAmount (String amount){
        this.amount = amount;
    }

    public void setCategory (String category){
        this.category = category;
    }

    public String getIncome (){
        String res =
                "            Title:    " + title + "\n\n" +
                "            Date:     " + date + "\n\n" +
                "            Price:    " + amount + "\n\n" +
                "            Category: " + category;
        return res;
    }

    public String toString() {
        return title;
    }
}
