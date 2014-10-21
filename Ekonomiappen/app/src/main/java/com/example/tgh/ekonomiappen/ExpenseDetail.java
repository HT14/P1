package com.example.tgh.ekonomiappen;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ExpenseDetail extends Fragment {
    private Controller controller;
    private TextView tvExpense;
    private String singleExpense = "";
    private String singleIncome = "";

    public ExpenseDetail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expense_detail, container, false);
        tvExpense = (TextView)view.findViewById(R.id.tvSingleEx);

        return view;
    }

    public void setExpense (String singleExpense){
        this.singleExpense = singleExpense;
    }

    public void setIncome (String singleIncome){
        this.singleIncome = singleIncome;
    }
    public void onResume (){
        super.onResume();
        tvExpense.setText(singleExpense);
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
