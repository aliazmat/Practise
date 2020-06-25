package doc.home.firstapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import doc.home.firstapp.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment {

    public FragmentTwo() {
        // Required empty public constructor
    }

    private String args;
    private FragmentContract listener;
    public FragmentTwo(String args) {
       this.args = args;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentContract)
        listener = (FragmentContract) context;
    }
    //int counter = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ((TextView)view.findViewById(R.id.text)).setText(args);
        view.findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.doOnClick("New Instance ");


            }
        });
        return view;
    }

    public interface FragmentContract{
         void doOnClick(String args);
    }

}