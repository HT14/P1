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
public class IncomeDetail extends Fragment {
    private Controller controller;
    private TextView tvIncome;
    private String singleIncome = "";

    public IncomeDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_income_detail, container, false);
        tvIncome = (TextView)view.findViewById(R.id.tvSingleIn);
        return view;
    }

    public void setIncome (String singleIncome){
        this.singleIncome = singleIncome;
    }

    public void onResume (){
        super.onResume();
        tvIncome.setText(singleIncome);
    }

    public void setController(Controller controller){
        this.controller = controller;
    }


}
