package danandzach.labpal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LabNotes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LabNotes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LabNotes extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LabNotes.
     */
    public static LabNotes newInstance() {
        LabNotes fragment = new LabNotes();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LabNotes() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lab_notes, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}