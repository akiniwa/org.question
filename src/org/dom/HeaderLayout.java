package org.dom;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

public class HeaderLayout extends LinearLayout {

    public HeaderLayout(Context context, int view_number) {
        super(context);

        /* layout setting */
        this.setOrientation(this.VERTICAL);
        this.setBackgroundColor(0xDDA0DDEE);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    60));
        this.setPadding(10, 10, 10, 10);

        /* parentlayout */
        LinearLayout parentLayout = new LinearLayout(context);
        parentLayout.setOrientation(LinearLayout.HORIZONTAL);

        /* create views */
        TextView titleView = new TextView(context);
        titleView.setText("Questionnaire title");
        titleView.setTextColor(Color.rgb(10,10,10));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);
        titleView.setLayoutParams(new LinearLayout.LayoutParams(
                    1100,
                    LinearLayout.LayoutParams.WRAP_CONTENT));


        TextView countView = new TextView(context);
        countView.setText(view_number + "/34");
        countView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        countView.setTextColor(Color.rgb(30,30,30));

        /* add views to parentlayout */
        parentLayout.addView(titleView);
        parentLayout.addView(countView);

        this.addView(parentLayout);
    }
}
