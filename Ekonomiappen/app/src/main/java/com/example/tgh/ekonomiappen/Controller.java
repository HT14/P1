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

    private ExpenseTable exTable;
    private ExpenseList expenseList;
    private IncomeTable incomeTableFragment;
    private IncomeList incomeList;
    private ExpenseDetail bkFragment;
    private IncomeDetail inFragment;

    private DatabaseHelper dbHelper;

    public Controller(MainActivity activity) {
        this.activity = activity;
        dbHelper = new DatabaseHelper(activity);
        initExpenseAndIncome ();

        sharedPrefFragment = new SharedPrefFragment();
        sharedPrefFragment.setController(this);

        bkFragment = new ExpenseDetail();
        bkFragment.setController(this);

        incomeFragment = new IncomeFragment();
        incomeFragment.setController(this);

        expenseFragment = new ExpenseFragment();
        expenseFragment.setController(this);

        resultFragment = new ResultFragment();
        resultFragment.setController(this);

        incomeTableFragment = new IncomeTable();
        incomeTableFragment.setController(this);

        exTable = new ExpenseTable();
        exTable.setController(this);

        expenseList = new ExpenseList();
        expenseList.setController(this);

        incomeList = new IncomeList();
        incomeList.setController(this);

        inFragment = new IncomeDetail();
        inFragment.setController(this);

        activity.setFragment(sharedPrefFragment, false);
    }

    public void initExpenseAndIncome (){
        List<Expense> expenseList = dbHelper.getAllExpenses();
        List<Income> incomeList = dbHelper.getAllIncomes();
    }

    public void saveExpenseClicked(String title, String date, String price, String category) {
        dbHelper.saveExpense(title, date, price, category);
        List<Expense> expenseList = dbHelper.getAllExpenses();

        for (Expense ut : expenseList) {
            String log = "Id: " + ut.getId() + " ,Title: " + ut.getTitle() + " ,Date: " + ut.getDate() +
                    " ,Price: " + ut.getPrice() + " ,Category: " + ut.getCategory();
            Log.d("Title: ", log);
        }
        dbHelper.close();
    }

    public void saveIncomeClicked(String title, String date, String amount, String category) {
        dbHelper.saveIncome (title, date, amount, category);
        List<Income> incomeList = dbHelper.getAllIncomes();

        for (Income in : incomeList) {
            String res = "Id: " + in.getId() + ", Title: " + in.getTitle() + ", Date: " + in.getDate() +
                    ", Amount: " + in.getAmount() + ", Category: " + in.getCategory();
            // Writing incomes to log
            Log.d("Title: ", res);
        }
        dbHelper.close();
    }

    public void registerUser() {
      activity.setFragment(resultFragment, true);
    }

    public void showIncomeFragment(){
        activity.setFragment(incomeFragment, true);
    }

    public void showExpenseFragment(){
        activity.setFragment(expenseFragment, true);
    }

    public void showIncomeTable(){
        activity.setFragment(incomeTableFragment, true);
    }

    public void showExpenseTable(){
        activity.setFragment(exTable, true);
    }

    public void showExpenseList(){
        activity.setFragment(expenseList, true);
    }

    public void showIncomeList(){
        activity.setFragment(incomeList, true);
    }

    public void expenseItemClicked(int position) {
        Expense expense = dbHelper.getExpense(position + 1);
        bkFragment.setExpense(expense.getExpense());
        activity.setFragment(bkFragment, true);
    }

    public void incomeItemClicked(int position) {
        Income income = dbHelper.getIncome(position + 1);
        inFragment.setIncome(income.getIncome());
        activity.setFragment(inFragment, true);
    }

    public String saveUserInfo() {
        String user = sharedPrefFragment.loadPrefs();
        return "Hi, " + user;
    }

    public String showTotalExpenses (){
        String sumExpense = String.valueOf(dbHelper.getTotalExpense());
        return sumExpense;
    }

    public String showTotalIncome (){
        String sumIncome = String.valueOf(dbHelper.getTotalIncome());
        return sumIncome;
    }

    public String showResult (){
        String result =  dbHelper.economyResult();
        return result;
    }
}
