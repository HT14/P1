package com.example.tgh.ekonomiappen;

<<<<<<< HEAD


=======
>>>>>>> tequam
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
<<<<<<< HEAD
    private Button btnIncome;
    private Button btnExpense;
    private Controller controller;
=======

    private Button btnIncomeTable;
    private Button btnIncomeList;
    private Button btnExpenseList;
    private Button btnExpenseTable;
    private Button btnAddExpense;
    private Button btnAddIncome;

    private Controller controller;
//    private DatabaseHelper dbHelper;
>>>>>>> tequam

    public ResultFragment() {
        // Required empty public constructor
    }

<<<<<<< HEAD
    String user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( getArguments() != null){
            user = getArguments().getString("user");
        }
    }

    public static ResultFragment newInstance(String user){
        ResultFragment frag = new ResultFragment();
        Bundle args = new Bundle();
        args.putString("user", user);
        frag.setArguments(args);
        return frag;
    }

=======
>>>>>>> tequam
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        initializeComponents(view);
<<<<<<< HEAD
        setUser(user);
=======
        initView();
>>>>>>> tequam
        return view;
    }

    private void initializeComponents(View view) {
        tvUser = (TextView)view.findViewById(R.id.tvUser);
        tvExpenseResult = (TextView)view.findViewById(R.id.tvExpenseResult);
        tvIncomeResult = (TextView)view.findViewById(R.id.tvIncomeResult);
<<<<<<< HEAD
        tvResult = (TextView)view.findViewById(R.id.tvResult);
        btnIncome = (Button)view.findViewById(R.id.btnIncome);
        btnExpense = (Button)view.findViewById(R.id.btnExpense);
    }

    private void setUser(String user) {
        tvUser.setText(user);
    }

    public void setExpenses(String expense) {
        tvExpenseResult.setText(expense);
    }

    public void setIncomes(String income) {
        tvIncomeResult.setText(income);
    }

    public void setResult(String result) {
        tvResult.setText(result);
=======
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
>>>>>>> tequam
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
