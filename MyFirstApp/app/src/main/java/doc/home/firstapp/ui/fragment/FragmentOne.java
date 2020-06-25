package doc.home.firstapp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import doc.home.firstapp.R;
import doc.home.firstapp.model.ListModel;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {



   List<ListModel> modelList = new ArrayList<>();

    public FragmentOne() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void createData(){

        for(int i=1;i<50;i++){
            ListModel listModel = new ListModel();
            listModel.setName("Name "+i);
            listModel.setImageURL("https://homepages.cae.wisc.edu/~ece533/images/cat.png");
            modelList.add(listModel);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_one, container, false);
        createData();
        ListView listview = view.findViewById(R.id.mylistview);
        MyListAdapter adapter = new MyListAdapter(getActivity());
        listview.setAdapter(adapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.updateData(modelList);
                adapter.notifyDataSetChanged();
            }
        }, 4000);
        return view;
    }

    public void updateLabel(String msg){
       // ((TextView)getView().findViewById(R.id.mylabel)).setText(msg);
    }
}