package com.example.tgh.ekonomiappen;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
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
    private Context mContext;


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
        sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
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
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String firstN  = firstname.getText().toString();
        String lastN  = lastname.getText().toString();
        editor.putString(FirstName, firstN);
        editor.putString(LastName, lastN);
        editor.commit();
    }

    /*
    public String getUser (){
        sharedpreferences = mContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String res;
        res = (sharedpreferences.getString(FirstName, ""));
        res = res +  (sharedpreferences.getString(LastName, ""));
        return res;
    }*/

    public String loadPrefs() {
        String res;
        String name = (sharedpreferences.getString(FirstName, " "));
        String Lname = sharedpreferences.getString(LastName, " ");
        res = name +" "+ Lname;
        return res;
    }
  /*  public String getUser (){
        sharedpreferences = this.getActivity().getPreferences(0);
        String restoredText = sharedpreferences.getString("FirstName", null);
        return restoredText;
    /*
    if (restoredText != null)  {
        mSaved.setText(restoredText, TextView.BufferType.EDITABLE);
        int selectionStart = prefs.getInt("selection-start", -1);
        int selectionEnd = prefs.getInt("selection-end", -1);
  if (selectionStart != -1 && selectionEnd != -1)
  {
     prefs.getAll()mModified.setSelection(selectionStart, selectionEnd);*/
}
