package com.example.tgh.ekonomiappen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TGH on 10/17/2014.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Economy.db";
    SQLiteDatabase database;

    public static final String TABLE_EXPENSES = "Expenses";
    public static final String TABLE_INCOMES = "Incomes";

    public static final String COLUMN_EXPENSE_ID = "expenseId";
    public static final String COLUMN_INCOME_ID = "incomeId";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_DATE = "Data";
    public static final String COLUMN_AMOUNT = "Amount";
    private static final String TEXT_TYPE = "VARCHAR(255)";

    // Expenses table create statement
    private static final String CREATE_TABLE_EXPENSE =  "CREATE TABLE " + TABLE_EXPENSES
            + " (" + COLUMN_EXPENSE_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_TITLE + " " + TEXT_TYPE + "," + COLUMN_DATE  + " " + TEXT_TYPE + ","
            + COLUMN_PRICE +  " INTEGER,"  + " " + COLUMN_CATEGORY +  " " +TEXT_TYPE +  " )";


    // Income table create statement
    private static final String CREATE_TABLE_INCOMES =  "CREATE TABLE " + TABLE_INCOMES
            + " (" + COLUMN_INCOME_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_TITLE + " " + TEXT_TYPE + "," + COLUMN_DATE  + " " + TEXT_TYPE + ","
            + COLUMN_AMOUNT +  " INTEGER,"  + " " + COLUMN_CATEGORY +  " " +TEXT_TYPE +  " )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // creating required tables
        sqLiteDatabase.execSQL(CREATE_TABLE_EXPENSE);
        sqLiteDatabase.execSQL(CREATE_TABLE_INCOMES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOMES);
        // create new tables
        onCreate(sqLiteDatabase);
    }

    public void saveIncome(String title,  String date, String price,  String category){
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_AMOUNT, price);
        values.put(COLUMN_CATEGORY, category);

        database.insert(TABLE_INCOMES, null, values);
    }

    public void saveExpense(String title,  String date, String amount,  String category){
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_PRICE, amount);
        values.put(COLUMN_CATEGORY, category);

        database.insert(TABLE_EXPENSES, null, values);
    }

    // Getting single expense
    public Expense getExpense(int id) {
        database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE_EXPENSES, new String[] {},
                COLUMN_EXPENSE_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        int prodId = cursor.getInt(0);
        String prodTitle = cursor.getString(1);
        String prodDate = cursor.getString(2);
        String prodPrice = cursor.getString(3);
        String prodCat = cursor.getString(4);

        Expense expense = new Expense(prodId, prodTitle, prodDate, prodPrice, prodCat);
        return expense;
    }

    // Getting All expenses
    public List<Expense> getAllExpenses() {
        List<Expense> expenseList = new ArrayList<Expense>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Expense expense = new Expense();
                expense.setId(cursor.getInt(0));
                expense.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                expense.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                expense.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                expense.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                expenseList.add(expense);
            } while (cursor.moveToNext());
        }
        return expenseList;
    }

    public Income getIncome(int id) {
        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_INCOMES, new String[]{}, COLUMN_INCOME_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        int incomeId = cursor.getInt(0);
        String incomeTitle = cursor.getString(1);
        String incomeDate = cursor.getString(2);
        String incomeAmount = cursor.getString(3);
        String incomeCat = cursor.getString(4);

        Income income = new Income(incomeId, incomeTitle, incomeDate, incomeAmount, incomeCat);
        return income;
    }

    // Getting All incomes
    public List<Income> getAllIncomes() {
        List<Income> incomeList = new ArrayList<Income>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_INCOMES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Income income = new Income();
                income.setId(cursor.getInt(0));
                income.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                income.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                income.setAmount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                income.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                // Adding income to list
                incomeList.add(income);
            } while (cursor.moveToNext());
        }
        // return income list
        return incomeList;
    }

    public int getTotalExpense() {
        int sumExpense=0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( "SELECT SUM(" + COLUMN_PRICE + ") FROM  " + TABLE_EXPENSES, null);
        cursor.moveToFirst();
        if(cursor.getCount()>0) {
            sumExpense=cursor.getInt(0);
        }
        return sumExpense;
    }

    public int getTotalIncome() {
        int sumIncome=0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( "SELECT SUM(" + COLUMN_AMOUNT + ") FROM  " + TABLE_INCOMES, null);
        cursor.moveToFirst();
        if(cursor.getCount()>0) {
            sumIncome=cursor.getInt(0);
        }
        return sumIncome;
    }

    public String economyResult (){
        String res;
        double result = getTotalIncome()-getTotalExpense();
        if (getTotalIncome()==0 & getTotalExpense()==0)
            res = "  You have no saved data.  Start inserting your expenses and incomes";
        else if (result >0 )
            res = "  Your financial situation is: Surplus :)";
        else
            res = " Your financial situation is: Deficit :(";

        return res;
    }
    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
