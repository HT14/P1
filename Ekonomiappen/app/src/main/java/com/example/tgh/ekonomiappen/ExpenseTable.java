package com.example.tgh.ekonomiappen;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ExpenseTable extends Fragment {
    private Controller controller;
    private DatabaseHelper dbHelper;
    private TableLayout stk;

    public ExpenseTable() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expense_table, container, false);
        stk = (TableLayout) view.findViewById(R.id.table_expense);
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
        tvTitle.setText("       TITLE             ");
        tvTitle.setTextColor(Color.WHITE);
        tvTitle.setGravity(Gravity.CENTER);
        row.addView(tvTitle);

        TextView tvDate = new TextView(getActivity());
        tvDate.setText("    DATE    ");
        tvDate.setTextColor(Color.WHITE);
        tvDate.setGravity(Gravity.CENTER);
        row.addView(tvDate);

        TextView tvCategory = new TextView(getActivity());
        tvCategory.setText("       CATEGORY  ");
        tvCategory.setTextColor(Color.WHITE);
        tvCategory.setGravity(Gravity.CENTER);
        row.addView(tvCategory);

        TextView tvPrice = new TextView(getActivity());
        tvPrice.setText("   PRICE  ");
        tvPrice.setTextColor(Color.WHITE);
        tvPrice.setGravity(Gravity.CENTER);
        row.addView(tvPrice);


        row.setBackgroundColor(Color.BLACK);
        stk.addView(row);

        List<Expense> expenses = getAllExpense();
        for (Expense expense : expenses) {
            row = new TableRow(getActivity());
            tvId = new TextView(getActivity());
            tvId.setText(" " + expense.getId());
            tvId.setTextColor(Color.BLACK);
            tvId.setGravity(Gravity.CENTER);
            row.addView(tvId);

            tvTitle = new TextView(getActivity());
            tvTitle.setText(" " + expense.getTitle() + "            ");
            tvTitle.setTextColor(Color.BLACK);
            tvTitle.setGravity(Gravity.LEFT);
            row.addView(tvTitle);

            tvDate = new TextView(getActivity());
            tvDate.setText(expense.getDate());
            tvDate.setTextColor(Color.BLACK);
            tvDate.setGravity(Gravity.CENTER);
            row.addView(tvDate);

            ImageView ivCategory = new ImageView(getActivity());
            if (expense.getCategory().equalsIgnoreCase("Livsmedel"))
                ivCategory.setImageResource(R.drawable.livsmedel);
            else if (expense.getCategory().equalsIgnoreCase("Fritid"))
                ivCategory.setImageResource(R.drawable.fritids);
            else if (expense.getCategory().equalsIgnoreCase("Resor"))
                ivCategory.setImageResource(R.drawable.airplane);
            else if (expense.getCategory().equalsIgnoreCase("Boende"))
                ivCategory.setImageResource(R.drawable.boende);
            else
                ivCategory.setImageResource(R.drawable.others);
            row.addView(ivCategory);


            tvPrice = new TextView(getActivity());
            tvPrice.setText(expense.getPrice());
            tvPrice.setTextColor(Color.BLACK);
            tvPrice.setGravity(Gravity.RIGHT);
            row.addView(tvPrice);
            stk.addView(row);
        }
    }

    public List<Expense> getAllExpense() {
        dbHelper = new DatabaseHelper(getActivity());
        List<Expense> expenseList = dbHelper.getAllExpenses();
        dbHelper.close();
        return expenseList;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
