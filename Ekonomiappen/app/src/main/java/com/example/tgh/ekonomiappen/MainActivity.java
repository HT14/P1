package com.example.tgh.ekonomiappen;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
<<<<<<< HEAD
    private Controller controller;
    private ExpenseFragment expense;
    private IncomeFragment income;
=======
    public Controller controller;
>>>>>>> tequam

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller(this);
    }

    public void setFragment(Fragment fragment, boolean backstack) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.upper_container, fragment);
        if (backstack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

<<<<<<< HEAD
    public void setExpense(ExpenseFragment expense) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.upper_container, (Fragment)expense);
        fragmentTransaction.commit();
    }

    public void setIncome(IncomeFragment income) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lower_container, (Fragment) income);
        fragmentTransaction.commit();
    }

=======
>>>>>>> tequam
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setResult(String user) {
        ResultFragment resultFragment = ResultFragment.newInstance(user);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.upper_container, resultFragment);
        fragmentTransaction.commit();
    }
}
