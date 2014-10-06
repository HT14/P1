package com.example.tgh.ekonomiappen;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SharedPrefFragment extends Fragment {
    private EditText firstname ;
    private EditText lastname;
    private Button register;

    private Controller controller;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String FirstName = "nameKey";
    public static final String LastName = "lastnameKey";


    public SharedPrefFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        firstname = (EditText) view.findViewById(R.id.etFirstname);
        lastname = (EditText) view.findViewById(R.id.etLastname);
        register = (Button)view.findViewById(R.id.btnRegister);
        registerListeners();
        return view;
    }

    private void registerListeners() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.registerUser();
            }
        });
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

   public void onResume(){
        super.onResume();
        sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(FirstName))
        {
            firstname.setText(sharedpreferences.getString(FirstName, ""));
        }

        if (sharedpreferences.contains(LastName))
        {
            lastname.setText(sharedpreferences.getString(LastName, ""));
        }
    }

    public void onPause(){
        super.onPause();
        sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String firstN  = firstname.getText().toString();
        String lastN  = lastname.getText().toString();
        editor.putString(FirstName, firstN);
        editor.putString(LastName, lastN);
        editor.commit();
    }

}
