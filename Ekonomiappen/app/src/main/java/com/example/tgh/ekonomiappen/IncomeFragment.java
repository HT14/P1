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
public class IncomeFragment extends Fragment {
    private EditText etTitle;
    private EditText etDatum;
    private EditText etBellop;
    private Spinner spKategori;
<<<<<<< HEAD:Ekonomiappen/app/src/main/java/com/example/tgh/ekonomiappen/IncomeFragment.java
    private Button btnSave_inkomst;
    private Button bntShowResult;
=======
    private Button btnSave;
    private Button btnAddIncome;
    private Button btnBack;
>>>>>>> tequam:Ekonomiappen/app/src/main/java/com/example/tgh/ekonomiappen/IncomeFragment.java
    private String kategoriStr = "LÖNÖVRIGT";
    private String[] kategorier = {"Lön","Övrigt"};
    private Controller controller;
 /*   private MainActivity mainActivity;
    private ResultFragment resultFragment;
    private SharedPrefFragment sharedPrefFragment;*/

    public IncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inkomst, container, false);
        initializeComponents(view);
        spKategori.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_row, kategorier));
        registerListeners();
<<<<<<< HEAD:Ekonomiappen/app/src/main/java/com/example/tgh/ekonomiappen/IncomeFragment.java
        resultButtonListeners();
=======
>>>>>>> tequam:Ekonomiappen/app/src/main/java/com/example/tgh/ekonomiappen/IncomeFragment.java
        return view;
    }

    private void initializeComponents(View view) {
        etTitle =(EditText)view.findViewById(R.id.etTitle_inkomst);
        etDatum = (EditText)view.findViewById(R.id.etDatum_inkomst);
        etBellop = (EditText)view.findViewById(R.id.etBellop);
        spKategori = (Spinner)view.findViewById(R.id.spKategori_inkomst);
<<<<<<< HEAD:Ekonomiappen/app/src/main/java/com/example/tgh/ekonomiappen/IncomeFragment.java
        btnSave_inkomst = (Button)view.findViewById(R.id.btnSave_inkomst);
        bntShowResult = (Button)view.findViewById(R.id.btnShowResult);
    }

    private void registerListeners() {
        btnSave_inkomst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.saveIncomeClicked();
                etTitle.setText("");
                etDatum.setText("");
                etBellop.setText("");
            }
        });
    }

    private void resultButtonListeners() {
        bntShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showResultFragment();
=======
        btnSave = (Button)view.findViewById(R.id.btnSave_Income);
        btnAddIncome = (Button)view.findViewById(R.id.btnAdd_Income);
        btnBack = (Button)view.findViewById(R.id.btnBack);
    }

    private void registerListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.saveIncomeClicked(getTitle(), getDatum(), getAmount(), getKategori());
                etTitle.setText("");
                etDatum.setText("");
                etBellop.setText("");
                controller.registerUser();
            }
        });

        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.saveIncomeClicked(getTitle(), getDatum(), getAmount(), getKategori());
                etTitle.setText("");
                etDatum.setText("");
                etBellop.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.registerUser();
>>>>>>> tequam:Ekonomiappen/app/src/main/java/com/example/tgh/ekonomiappen/IncomeFragment.java
            }
        });
    }

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

    public String getAmount() {
        return etBellop.getText().toString();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
