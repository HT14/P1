package com.example.tgh.ekonomiappen;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class ExpenseFragment extends Fragment {
    private EditText etTitle;
    private EditText etDatum;
    private EditText etPrice;
    private Spinner spKategori;
    private Button btSave;
    //private Button bntShowResult;
    private String kategoriStr = "LivsmedelFritidResorBoendeÖvrigt";
    private String[] kategorier = {"Livsmedel", "Fritid", "Resor", "Boende","Övrigt"};
    private Controller controller;

    public ExpenseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utgifts, container, false);
        etTitle = (EditText)view.findViewById(R.id.etTitle_utgift);
        etDatum = (EditText)view.findViewById(R.id.etDatum_utgift);
        etPrice = (EditText)view.findViewById(R.id.etPrice);
        spKategori = (Spinner)view.findViewById(R.id.spKategori_utgift);
      //  bntShowResult = (Button)view.findViewById(R.id.btnShowResult);
        btSave = (Button)view.findViewById(R.id.btnSave_utgift);
        registerListeners();
        spKategori.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_row, kategorier));
      //  resultButtonListeners();
        return view;
    }

    private void registerListeners() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.saveExpenseClicked(etTitle.getText().toString()
                        , etDatum.getText().toString()
                        , etPrice.getText().toString()
                        , spKategori.getSelectedItem().toString());
                etTitle.setText("");
                etDatum.setText("");
                etPrice.setText("");
            }
        });
    }
/*
    private void resultButtonListeners() {
        bntShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showResultFragment();
            }
        });
    }
    */
    public String getKategori() {
        return spKategori.getSelectedItem().toString();
    }

    public void setKategori(String operator) {
        int index = kategoriStr.indexOf(operator.charAt(0));
        if(index>=0 && spKategori!=null)
            spKategori.setSelection(index);
    }

    public String getTitle() {
        return etTitle.getText().toString();
    }

    public String getDatum() {
        return etDatum.getText().toString();
    }

    public String getPrice() {
        return etPrice.getText().toString();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
