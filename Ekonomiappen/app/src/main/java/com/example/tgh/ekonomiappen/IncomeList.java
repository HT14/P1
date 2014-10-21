package com.example.tgh.ekonomiappen;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.tgh.ekonomiappen.helper.ReusableHelper;

import java.util.ArrayList;
import java.util.List;

/*
En fragment which show the list of incomes.
When one list is clicked shows the detail of that list in IncomeDetail fragment.
 */

public class IncomeList extends Fragment {
    private ListView lvIncome;
    private Controller controller;

    public IncomeList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_income_list, container, false);
        lvIncome = (ListView) view.findViewById(R.id.lvIncome);

        ReusableHelper reusableHelper = new ReusableHelper(getActivity());
        List<Income> incomeList = reusableHelper.getIncomes();

        final ArrayAdapter<Income> adapter;
        adapter = new ArrayAdapter<Income>(getActivity(), R.layout.income_view, incomeList);
        lvIncome.setAdapter(adapter);
        lvIncome.setOnItemClickListener(new ListViewListener());
        return view;
    }

    private class ListViewListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            controller.incomeItemClicked(position);
        }
    }

     public void setController(Controller controller) {
        this.controller = controller;
    }
}
