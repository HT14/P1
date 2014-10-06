package com.example.tgh.ekonomiappen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TGH on 9/29/2014.
 */
public class UtgiftDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Economi.db";
    public static final int DATABASE_VERSION = 1;
    SQLiteDatabase database;

    private static final String TEXT_TYPE = "VARCHAR(255)";
    private static final String SQL_CREATE_TABLE_UTGIFT =
            "CREATE TABLE " + DatabaseContract.DatabaseEntry.TABLE_NAME_1 + " (" +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_UTGIFT_ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_TITLE + " " + TEXT_TYPE + "," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_DATUM + " " + TEXT_TYPE + "," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_PRICE +  " " +TEXT_TYPE + "," +
                    DatabaseContract.DatabaseEntry.COLUMN_NAME_KATEGOGI +  " " +TEXT_TYPE +  " )";

    public UtgiftDatabase(Context context) {
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
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_UTGIFT);
    }

    public void save(String title,  String datum, String price,  String kategori){
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_TITLE, title);
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_DATUM, datum);
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_PRICE, price);
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME_KATEGOGI, kategori);

        database.insert(DatabaseContract.DatabaseEntry.TABLE_NAME_1, null, values);
    }
    // Getting single expense
    Utgifter getExpense(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DatabaseContract.DatabaseEntry.TABLE_NAME_1, new String[] {},
                                DatabaseContract.DatabaseEntry.COLUMN_NAME_UTGIFT_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Utgifter utgifter = new Utgifter(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return expense
        return utgifter;
    }

    /*
    public Map<String,String> getUtgifter(){
        database = getReadableDatabase();

        //Cursor c = database.query(DatabaseContract.DatabaseEntry.TABLE_NAME_1,  projection, null, null, null, null, sortOrder);                           // The values for the WHERE clause
        Cursor c= database.rawQuery("SELECT * from " + DatabaseContract.DatabaseEntry.TABLE_NAME_1, new String[]{});
        Map<String, String> tableResult = new HashMap<String, String>();
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
        return tableResult;
    }*/

    // Getting All expenses
    public List<Utgifter> getAllExpenses() {
        List<Utgifter> utgiftList = new ArrayList<Utgifter>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DatabaseContract.DatabaseEntry.TABLE_NAME_1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Utgifter utgifter = new Utgifter();
                utgifter.setId(Integer.parseInt(cursor.getString(0)));
                utgifter.setTitle(cursor.getString(1));
                utgifter.setDate(cursor.getString(2));
                utgifter.setPrie(cursor.getString(3));
                utgifter.setCategory(cursor.getString(4));

                // Adding costs to list
                utgiftList.add(utgifter);
            } while (cursor.moveToNext());
        }

        // return cost list
        return utgiftList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.DatabaseEntry.TABLE_NAME_1);
        // create new tables
        onCreate(sqLiteDatabase);
    }
}
