package com.example.tgh.ekonomiappen;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


public class IncomeTable extends Fragment {

    private Controller controller;
    private DatabaseHelper dbHelper;
    private TableLayout stk;

    public IncomeTable() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_income_table, container, false);
        stk = (TableLayout) view.findViewById(R.id.table_main);
        init();
        return view;
    }

    private void init(){

        TextView tvId = new TextView(getActivity());
        TableRow row = new TableRow(getActivity());
        tvId.setText(" Id  ");
        tvId.setTextColor(Color.WHITE);
        tvId.setGravity(Gravity.CENTER);
        row.addView(tvId);

        TextView tvTitle = new TextView(getActivity());
        tvTitle.setText("       TITLE        ");
        tvTitle.setTextColor(Color.WHITE);
        tvTitle.setGravity(Gravity.CENTER);
        row.addView(tvTitle);

        TextView tvDate = new TextView(getActivity());
        tvDate.setText("    DATE    ");
        tvDate.setTextColor(Color.WHITE);
        tvDate.setGravity(Gravity.CENTER);
        row.addView(tvDate);

        TextView tvAmount = new TextView(getActivity());
        tvAmount.setText("   AMOUNT  ");
        tvAmount.setTextColor(Color.WHITE);
        tvAmount.setGravity(Gravity.CENTER);
        row.addView(tvAmount);

        TextView tvCategory = new TextView(getActivity());
        tvCategory.setText("  CATEGORY  ");
        tvCategory.setTextColor(Color.WHITE);
        tvCategory.setGravity(Gravity.CENTER);
        row.addView(tvCategory);
        row.setBackgroundColor(Color.BLACK);
        stk.addView(row);

        List<Income> incomes = getAllIncomes();
        for (Income income : incomes) {
            row = new TableRow(getActivity());
            tvId = new TextView(getActivity());
            tvId.setText(" " + income.getId());
            tvId.setTextColor(Color.BLACK);
            tvId.setGravity(Gravity.CENTER);
            row.addView(tvId);

            tvTitle = new TextView(getActivity());
            tvTitle.setText(" " + income.getTitle() + "         ");
            tvTitle.setTextColor(Color.BLACK);
            tvTitle.setGravity(Gravity.LEFT);
            row.addView(tvTitle);

            tvDate = new TextView(getActivity());
            tvDate.setText(income.getDate());
            tvDate.setTextColor(Color.BLACK);
            tvDate.setGravity(Gravity.CENTER);
            row.addView(tvDate);

            tvAmount = new TextView(getActivity());
            tvAmount.setText(income.getAmount());
            tvAmount.setTextColor(Color.BLACK);
            tvAmount.setGravity(Gravity.RIGHT);
            row.addView(tvAmount);
            //stk.addView(row);

            tvCategory = new TextView(getActivity());
            tvCategory.setText(income.getCategory());
            tvCategory.setTextColor(Color.BLACK);
            tvCategory.setGravity(Gravity.CENTER);
            row.addView(tvCategory);
            stk.addView(row);
        }
    }

    public List<Income> getAllIncomes() {
        dbHelper = new DatabaseHelper(getActivity());
        List<Income> incomeList = dbHelper.getAllIncomes();
        dbHelper.close();
        return incomeList;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

}
