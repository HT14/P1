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

import java.util.List;

/*
En fragment which show the list of expenses.
When one list is clicked shows the detail of that list in ExpenseDetail fragment.
 */

public class ExpenseList extends Fragment {
    private ListView list;
    private Controller controller;

    public ExpenseList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        list = (ListView) view.findViewById(R.id.lvExpense);

        ReusableHelper reusableHelper = new ReusableHelper(getActivity());
        List<Expense> expenseList = reusableHelper.getExpenses();

        final ArrayAdapter<Expense> adapter;
        adapter = new ArrayAdapter<Expense>(getActivity(), R.layout.income_view, expenseList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new ListViewListener());
        return view;
    }

    private class ListViewListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            controller.expenseItemClicked(position);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}