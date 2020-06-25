package doc.home.firstapp.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import doc.home.firstapp.R;
import doc.home.firstapp.model.ListModel;

public class MyListAdapter extends BaseAdapter {

    List<ListModel> modelList = new ArrayList<>();
    private LayoutInflater mInflater;
    public MyListAdapter(Context context){
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.row_item, null);
        ((TextView)convertView.findViewById(R.id.name)).setText(modelList.get(position).getName());
        return convertView;
    }

    public void updateData(List<ListModel> list){
        modelList = list;
    }
}
