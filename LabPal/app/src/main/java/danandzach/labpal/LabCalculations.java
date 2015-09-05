package danandzach.labpal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import org.json.JSONException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LabCalculations.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LabCalculations#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LabCalculations extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LabCalculations.
     */

    public static LabCalculations newInstance() {
        LabCalculations fragment = new LabCalculations();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LabCalculations() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lab_calculations, container, false);

        //Set up the buttons
        Button ac = (Button)v.findViewById(R.id.b_AC);
        Button power = (Button)v.findViewById(R.id.b_10x);
        Button slash = (Button)v.findViewById(R.id.b_slash);
        Button del = (Button)v.findViewById(R.id.b_del);
        Button b7 = (Button)v.findViewById(R.id.b7);
        Button b8 = (Button)v.findViewById(R.id.b8);
        Button b9 = (Button)v.findViewById(R.id.b9);
        Button b_star = (Button)v.findViewById(R.id.b_star);
        Button b4 = (Button)v.findViewById(R.id.b4);
        Button b5 = (Button)v.findViewById(R.id.b5);
        Button b6 = (Button)v.findViewById(R.id.b6);
        Button b_minus = (Button)v.findViewById(R.id.b_minus);
        Button b1 = (Button)v.findViewById(R.id.b1);
        Button b2 = (Button)v.findViewById(R.id.b2);
        Button b3 = (Button)v.findViewById(R.id.b3);
        Button b_plus = (Button)v.findViewById(R.id.b_plus);
        Button b0 = (Button)v.findViewById(R.id.b0);
        Button b_dot = (Button)v.findViewById(R.id.b_dot);
        Button b_err = (Button)v.findViewById(R.id.b_err);
        Button b_equals = (Button)v.findViewById(R.id.b_equals);


        AutoCompleteTextView constants_search = (AutoCompleteTextView)v.findViewById(R.id.calculator_search);
        try {
            String [] adapter_list = new String[Data.getConstants_data().getJSONArray(Data.getConstants_array_name()).length()];
            for(int i = 0; i < Data.getConstants_data().getJSONArray(Data.getConstants_array_name()).length(); i++){
                adapter_list[i] = Data.getConstants_data().getJSONArray(Data.getConstants_array_name()).getJSONObject(i).optString("Quantity ");
            }

            final ArrayAdapter<String> auto_complete = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, adapter_list);
            constants_search.setAdapter(auto_complete);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Lab Calculator");
    }

}