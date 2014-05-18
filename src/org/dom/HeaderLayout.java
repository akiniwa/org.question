package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;

public class HeaderLayout extends LinearLayout {

    public HeaderLayout(Context context, int view_number, int totalPage) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.header_layout, this, true);

        /* create views */
        TextView titleView = (TextView)findViewById(R.id.header_titleview);
        titleView.setTextColor(Color.rgb(10,10,10));

        TextView countView = (TextView)findViewById(R.id.header_countview);
        countView.setText(view_number + "/" + totalPage);
        countView.setTextColor(Color.rgb(30,30,30));
    }
}
