package com.example.tgh.ekonomiappen;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ResultFragment extends Fragment {
    private TextView tvUser;
    private TextView tvExpenseResult;
    private TextView tvIncomeResult;
    private TextView tvResult;

    private Button btnIncomeTable;
    private Button btnIncomeList;
    private Button btnExpenseList;
    private Button btnExpenseTable;
    private Button btnAddExpense;
    private Button btnAddIncome;

    private Controller controller;
//    private DatabaseHelper dbHelper;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        initializeComponents(view);
        initView();
        return view;
    }

    private void initializeComponents(View view) {
        tvUser = (TextView)view.findViewById(R.id.tvUser);
        tvExpenseResult = (TextView)view.findViewById(R.id.tvExpenseResult);
        tvIncomeResult = (TextView)view.findViewById(R.id.tvIncomeResult);
        tvResult = (TextView)view.findViewById(R.id.tvSurplusLoss);
        btnIncomeTable = (Button)view.findViewById(R.id.btnIncomeTable);
        btnIncomeList = (Button)view.findViewById(R.id.btnIncomeList);
        btnExpenseList = (Button)view.findViewById(R.id.btnExpenseList);
        btnExpenseTable = (Button)view.findViewById(R.id.btnExpenseTable);
        btnAddExpense = (Button)view.findViewById(R.id.btnAddExpense);
        btnAddIncome = (Button)view.findViewById(R.id.btnAddIncome);

        registerListeners();
    }

    public void initView(){
        tvUser.setText( "  " + controller.saveUserInfo());
        tvExpenseResult.setText( "  " + controller.showTotalExpenses());
        tvIncomeResult.setText( "  "+ controller.showTotalIncome());
        tvResult.setText("  " + controller.showResult());
    }

      private void registerListeners() {
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showExpenseFragment();
            }
        });

        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showIncomeFragment();
            }
        });

        btnIncomeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showIncomeTable();
            }
        });

        btnExpenseTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showExpenseTable();
            }
        });

        btnExpenseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showExpenseList();
            }
        });

        btnIncomeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showIncomeList();
            }
        });
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
