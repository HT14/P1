package com.example.tgh.ekonomiappen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TGH on 9/29/2014.
 */
public class IncomeDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Economi.db";
    SQLiteDatabase database;

    private static final String TEXT_TYPE = "VARCHAR(255)";

    private static final String SQL_CREATE_TABLE_INKOMST =
            "CREATE TABLE " + DatabaseContract.DatabaseEntry.TABLE_NAME_2 + " (" +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_INKOMST_ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_TITLE + TEXT_TYPE + "," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_DATUM + TEXT_TYPE + "," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_BELLOP + TEXT_TYPE + "," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_KATEGOGI + TEXT_TYPE + " )";

    public IncomeDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){
       database = getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL(SQL_CREATE_TABLE_INKOMST);
    }

    public void save(String title, String datum, String bellop, String kategori){
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_TITLE, title);
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_DATUM, datum);
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_BELLOP, bellop);
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_KATEGOGI, kategori);

        database.insert(DatabaseContract.DatabaseEntry.TABLE_NAME_2, null, values);
    }

    public Cursor getInkomster(int id){
   // public Map<String,String> getInkomster(){
        database = getReadableDatabase();

        //Cursor c = database.query(DatabaseContract.DatabaseEntry.TABLE_NAME_1,  projection, null, null, null, null, sortOrder);                           // The values for the WHERE clause
        Cursor c= database.rawQuery(DatabaseContract.DatabaseEntry.COLUMN_NAME_TITLE, new String[]{});
        /*Map<String, String> tableResult = new HashMap<String, String>();
        int counter = 0;
        if( c.moveToFirst() ){
            do{
                if(counter < c.getColumnCount() ){
                    tableResult.put(c.getColumnName(counter), c.getString(counter));
                    counter += 1;
                }
                //  long itemId = c.getLong(c.getColumnIndexOrThrow( DatabaseContract.DatabaseEntry.COLUMN_NAME_UTGIFT_ID));
                // Log.d("Utgifter", c.getString(1) + " " + c.getString(2) + " " + c.getString(3) +" " + c.getString(3));
            }while(c.moveToNext());
        }
        return tableResult;*/
        return c;
    }

    // Getting All incomes
    public List<Income> getAllIncomes() {
        List<Income> incomeList = new ArrayList<Income>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DatabaseContract.DatabaseEntry.TABLE_NAME_1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Income income = new Income();
                income.setId(Integer.parseInt(cursor.getString(0)));
                income.setTitle(cursor.getString(1));
                income.setDate(cursor.getString(2));
                income.setBellop(cursor.getString(3));
                income.setCategory(cursor.getString(4));

                // Adding income to list
                incomeList.add(income);
            } while (cursor.moveToNext());
        }

        // return income list
        return incomeList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.DatabaseEntry.TABLE_NAME_2);
        // create new tables
        onCreate(sqLiteDatabase);
    }
}
