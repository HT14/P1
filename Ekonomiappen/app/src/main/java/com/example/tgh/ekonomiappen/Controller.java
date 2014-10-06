package com.example.tgh.ekonomiappen;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TGH on 9/29/2014.
 */
public class Controller {
    private MainActivity activity;
    private InkomstFragment inkomstFragment;
    private UtgiftsFragment utgiftsFragment;
    private UtgiftDatabase utgiftdb;
    private IncomeDatabase incomedb;
    private SharedPrefFragment sharedPrefFragment;

  /*  public Controller(MainActivity mainActivity, SharedPrefFragment sharedPrefFragment, UtgiftsFragment utgiftsFragment, InkomstFragment inkomstFragment) {
        this.activity = mainActivity;
        this.sharedPrefFragment = sharedPrefFragment;
        this.inkomstFragment = inkomstFragment;
        this.utgiftsFragment = utgiftsFragment;

        utgiftsFragment.setController(this);
        inkomstFragment.setController(this);
        sharedPrefFragment.setController(this);

        utgiftdb = new UtgiftDatabase(activity);
        inkomstdb = new InkomstDatabase(activity);
    }
*/
    public Controller(MainActivity activity) {
        this.activity = activity;
        sharedPrefFragment = new SharedPrefFragment();
        inkomstFragment = new InkomstFragment();
        utgiftsFragment = new UtgiftsFragment();

        utgiftsFragment.setController(this);
        inkomstFragment.setController(this);
        sharedPrefFragment.setController(this);

        utgiftdb = new UtgiftDatabase(activity);
        incomedb = new IncomeDatabase(activity);
        activity.setFragment(sharedPrefFragment, false);
    }

    public void saveUtgiftClicked() {
        utgiftdb.open();
        utgiftdb.save(utgiftsFragment.getTitle(), utgiftsFragment.getDatum(), utgiftsFragment.getPrice(), utgiftsFragment.getKategori());
        List<Utgifter> utgiftList = utgiftdb.getAllExpenses();

        Log.d("Reading: ", "Reading all incomes..");

        for (Utgifter ut : utgiftList) {
            String log = "Id: " + ut.getId() + " ,Title: " + ut.getTitle() + " ,Date: " + ut.getDate() +
                    " ,Price: " + ut.getPrice() + " ,Category: " + ut.getCategory();

            // Writing incomes to log
            Log.d("Title: ", log);
        }
        //Map<String,String> utgftInfo = utgiftdb.getUtgifter();
        utgiftdb.close();
    }

    public void saveInkomstClicked() {
        incomedb.open();
        incomedb.save(inkomstFragment.getTitle(), inkomstFragment.getDatum(), inkomstFragment.getBellop(), inkomstFragment.getKategori());
        List<Income> incomeList = incomedb.getAllIncomes();

       // Reading all incomes
        Log.d("Reading: ", "Reading all incomes..");

        for (Income in : incomeList) {
            String log = "Id: " + in.getId() + " ,Title: " + in.getTitle() + " ,Date: " + in.getDate() +
                    " ,Bellop: " + in.getBellop() + " ,Kategori: " + in.getCategory();

            // Writing incomes to log
            Log.d("Title: ", log);
        }
        incomedb.close();
    }


    public void registerUser() {
        activity.setUtgifter(utgiftsFragment);
        activity.setInkomster(inkomstFragment);
    }
}
