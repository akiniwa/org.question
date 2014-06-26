package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;

public class ListLinearLayout extends LinearLayout {

    public ListLinearLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list, this, true);

        /* create views */
        TextView titleView = (TextView)findViewById(R.id.header_titleview);
        titleView.setTextColor(Color.rgb(10,10,10));

        TextView countView = (TextView)findViewById(R.id.header_countview);
        countView.setText("最後のページ");
        countView.setTextColor(Color.rgb(30,30,30));
     }
}
