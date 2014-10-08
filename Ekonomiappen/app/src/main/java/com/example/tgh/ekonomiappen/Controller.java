package com.example.tgh.ekonomiappen;

import android.util.Log;

import java.util.List;

/**
 * Created by TGH on 9/29/2014.
 */
public class Controller {
    private MainActivity activity;
    private IncomeFragment incomeFragment;
    private ExpenseFragment expenseFragment;
    private ResultFragment resultFragment;
    private SharedPrefFragment sharedPrefFragment;
    private ExpenseDatabase expensedb;
    private IncomeDatabase incomedb;

    public Controller(MainActivity activity) {
        this.activity = activity;
        sharedPrefFragment = new SharedPrefFragment();
        incomeFragment = new IncomeFragment();
        expenseFragment = new ExpenseFragment();
        resultFragment = new ResultFragment();

        expenseFragment.setController(this);
        incomeFragment.setController(this);
        sharedPrefFragment.setController(this);
        resultFragment.setController(this);

        expensedb = new ExpenseDatabase(activity);
        incomedb = new IncomeDatabase(activity);

        activity.setFragment(sharedPrefFragment, false);
    }

    public void saveExpenseClicked(String title, String date, String price, String category) {
        expensedb.open();
        expensedb.save(title, date, price, category);
        List<Expense> utgiftList = expensedb.getAllExpenses();

        for (Expense ut : utgiftList) {
            String log = "Id: " + ut.getId() + " ,Title: " + ut.getTitle() + " ,Date: " + ut.getDate() +
                    " ,Price: " + ut.getPrice() + " ,Category: " + ut.getCategory();

            // Writing incomes to log
            Log.d("Title: ", log);
        }
        //Map<String,String> utgftInfo = expensedb.getUtgifter();
        expensedb.close();
    }

    public void saveIncomeClicked() {
        incomedb.open();
        incomedb.save(incomeFragment.getTitle(), incomeFragment.getDatum(), incomeFragment.getBellop(), incomeFragment.getKategori());
        List<Income> incomeList = incomedb.getAllIncomes();

       // Reading all incomes
      for (Income in : incomeList) {
            String log = "Id: " + in.getId() + " ,Title: " + in.getTitle() + " ,Date: " + in.getDate() +
                    " ,Bellop: " + in.getBellop() + " ,Kategori: " + in.getCategory();

            // Writing incomes to log
            Log.d("Title: ", log);
        }
        incomedb.close();
    }

    public void registerUser() {
        activity.setExpense(expenseFragment);
        activity.setIncome(incomeFragment);
    }

    public void showResultFragment() {
        String user = sharedPrefFragment.loadPrefs();
        Log.d("test", "resultFrag ? " + (resultFragment == null ? "null" : "ok"));
        Log.d("test", "user ? " + (user == null ? "null" : "ok"));
        //resultFragment.setUser(user);
        activity.setResult(user);
    }
}
