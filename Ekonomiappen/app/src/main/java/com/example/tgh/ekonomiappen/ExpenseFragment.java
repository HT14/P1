package com.example.tgh.ekonomiappen;



import android.IntentIntegrator;
import android.IntentResult;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class ExpenseFragment extends Fragment {
    private EditText etTitle;
    private EditText etDatum;
    private EditText etPrice;
    private TextView tvscan;
    private Spinner spKategori;
    private Button btSave;
    private Button btnBack;
    private Button btnAddExpense;
    private Button scanBtn;

    private String kategoriStr = "LivsmedelFritidResorBoendeÖvrigt";
    private String[] kategorier = {"Livsmedel", "Fritid", "Resor", "Boende","Övrigt"};
    private Controller controller;
    IntentIntegrator scanIntegrator;

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
        btSave = (Button)view.findViewById(R.id.btnSave_utgift);
        btnAddExpense = (Button)view.findViewById(R.id.btnAdd_expense);
        btnBack = (Button)view.findViewById(R.id.btnBack);
        scanBtn = (Button) view.findViewById(R.id.scan_button);
       // tvscan = (TextView)view.findViewById(R.id.tvscan);
        registerListeners();
        scanIntegrator = new IntentIntegrator(this);

        spKategori.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_row, kategorier));
        return view;
    }

    private void registerListeners() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.saveExpenseClicked (getTitle(), getDatum(), getPrice(), getKategori());
                etTitle.setText("");
                etDatum.setText("");
                etPrice.setText("");
                controller.registerUser();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.registerUser();
            }
        });

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.scan_button){
                  //  IntentIntegrator scanIntegrator = new IntentIntegrator(getTargetFragment());
                    scanIntegrator.initiateScan();
                    //scan
                }
            }

        });

        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.saveExpenseClicked (getTitle(), getDatum(), getPrice(), getKategori());
                etTitle.setText("");
                etDatum.setText("");
                etPrice.setText("");
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

    public String getPrice() {
        return etPrice.getText().toString();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        //retrieve scan result
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            etTitle.setText("CONTENT: " + scanContent);

        }
        else{
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
/*
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        AlertDialog scanningResult = IntentIntegrator.showDownloadDialog();
        //IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        //retrieve scan result
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            etTitle.setText("CONTENT: " + scanContent);
        }
        else{
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
*/

}
