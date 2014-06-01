package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;

public class HeaderLayout extends LinearLayout {
    Globals globals;
    //public HeaderLayout(Context context, int view_number, int totalPage) {
    public HeaderLayout(Context context, Globals g) {
        super(context);
        globals = g;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.header_layout, this, true);

        /* create views */
        TextView titleView = (TextView)findViewById(R.id.header_titleview);
        titleView.setTextColor(Color.rgb(10,10,10));

        TextView countView = (TextView)findViewById(R.id.header_countview);
        countView.setText(globals.getPage() + "/" + globals.getTotalPage());
        countView.setTextColor(Color.rgb(30,30,30));
    }
    public HeaderLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.header_layout, this, true);

        /* create views */
        TextView titleView = (TextView)findViewById(R.id.header_titleview);
        titleView.setTextColor(Color.rgb(10,10,10));

        TextView countView = (TextView)findViewById(R.id.header_countview);
        countView.setText("最後のページ");
        countView.setTextColor(Color.rgb(30,30,30));
     }
}
