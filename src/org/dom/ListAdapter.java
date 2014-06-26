package org.dom;

import android.widget.ArrayAdapter;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;

public class ListAdapter extends ArrayAdapter<Item> {
    public ListAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
    }
    private LayoutInflater li;

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.itemlistrow, null);
            }

            Item items = getItem(position);
            final int p = position;
            if (items != null) {
                TextView tt = (TextView) v.findViewById(R.id.text);
                CheckBox cb = (CheckBox) v.findViewById(R.id.check);
                if (tt != null) {
                    tt.setText(items.getText());
                    cb.setChecked(false);
                }
                cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                        boolean isChecked) {
                        Item items = getItem(p);
                        items.setChecked(isChecked);
                    }
                });
            }
            return v;
        }

}
