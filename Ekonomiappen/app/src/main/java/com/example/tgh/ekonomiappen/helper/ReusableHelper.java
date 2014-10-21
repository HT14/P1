package com.example.tgh.ekonomiappen.helper;

import android.app.Activity;

import com.example.tgh.ekonomiappen.DatabaseHelper;
import com.example.tgh.ekonomiappen.Expense;
import com.example.tgh.ekonomiappen.Income;
import com.example.tgh.ekonomiappen.MainActivity;

import java.util.List;

public class ReusableHelper {

    public List<Expense> expenses;
    public List<Income> incomes;

    private DatabaseHelper dbHelper;

    public ReusableHelper (Activity activity){
        dbHelper = new DatabaseHelper(activity);
    }

    public List<Expense> getExpenses(){
      return dbHelper.getAllExpenses();
    }

    public Expense getExpense(int id){
        return dbHelper.getExpense(id);
    }

    public List<Income> getIncomes(MainActivity activity){
        return dbHelper.getAllIncomes();
    }

    public List<Income> getIncomes(){
        return dbHelper.getAllIncomes();
    }

    public Income getIncome(MainActivity activity, int id){
        return dbHelper.getIncome(id);
    }
}
