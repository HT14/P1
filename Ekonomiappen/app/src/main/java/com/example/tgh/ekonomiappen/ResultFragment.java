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
    private Button btnIncome;
    private Button btnExpense;
    private Controller controller;

    public ResultFragment() {
        // Required empty public constructor
    }

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        initializeComponents(view);
        setUser(user);
        return view;
    }

    private void initializeComponents(View view) {
        tvUser = (TextView)view.findViewById(R.id.tvUser);
        tvExpenseResult = (TextView)view.findViewById(R.id.tvExpenseResult);
        tvIncomeResult = (TextView)view.findViewById(R.id.tvIncomeResult);
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
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
